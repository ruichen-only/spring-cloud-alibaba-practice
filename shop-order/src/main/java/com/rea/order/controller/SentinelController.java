package com.rea.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CRR
 */
@RestController
public class SentinelController {

    @GetMapping("/testFlow")
    @SentinelResource(value = "testFlow",
            blockHandlerClass = BlockHandler.class,
            blockHandler = "handleException",
            fallback = "handlerError",
            fallbackClass = BlockHandler.class)
    public String testFlow() {
        return "testFlow";
    }

    @GetMapping("/testDegrade")
    @SentinelResource(value = "testDegrade",
            blockHandlerClass = BlockHandler.class,
            blockHandler = "handleException",
            fallback = "handlerError",
            fallbackClass = BlockHandler.class)
    public String testDegrade() {
        return "testDegrade";
    }
}
