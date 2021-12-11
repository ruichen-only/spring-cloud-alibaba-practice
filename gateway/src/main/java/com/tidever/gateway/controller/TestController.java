package com.tidever.gateway.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CRR
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${base.name}")
    String name;

    @RequestMapping("name")
    public String name() {
        return name;
    }
}
