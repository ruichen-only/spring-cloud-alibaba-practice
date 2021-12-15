package com.rea.product.controller;

import cn.hutool.json.JSONUtil;
import com.rea.mbg.model.ShopProduct;
import com.rea.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CRR
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct")
    public ShopProduct getProduct(Integer pid) {
        ShopProduct product = productService.findByPid(pid);
        log.info("查询到商品:" + JSONUtil.toJsonStr(product));
        return product;
    }
}
