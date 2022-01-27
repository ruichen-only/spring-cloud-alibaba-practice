package com.rea.order.controller;

import cn.hutool.json.JSONUtil;
import com.rea.mbg.model.ShopOrder;
import com.rea.mbg.model.ShopProduct;
import com.rea.order.service.OrderService;
import com.rea.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CRR
 */
@RestController
@Slf4j
public class OrderController {

    @Reference
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/order")
    public ShopOrder order(Integer pid) {
        log.info(">>-----客户下单，这时候要调用商品微服务查询商品信息");
        ShopProduct product = productService.findByPid(pid);
        log.info(">>-----" + JSONUtil.toJsonStr(product));

        ShopOrder order = new ShopOrder();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getName());
        order.setPprice(product.getPrice());
        order.setNumber(10);
        log.info(">>-----" + JSONUtil.toJsonStr(order));

        orderService.save(order);

        //下单成功之后,将消息放到mq中
        rocketMQTemplate.convertAndSend("order-topic", order);

        return order;
    }
}
