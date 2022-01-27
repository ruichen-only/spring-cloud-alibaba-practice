package com.rea.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.rea.mbg.model.ShopOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author CRR
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "order-topic", consumerGroup = "test-group")
public class MessageServiceImpl implements RocketMQListener<ShopOrder> {

    @Override
    public void onMessage(ShopOrder shopOrder) {
        log.info("发送下单邮件成功：" + JSON.toJSONString(shopOrder));
    }
}
