package com.rea.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CRR
 */
@RestController
public class SentinelController {

    @GetMapping("/testFlow")
    public String testFlow() {
        return "testFlow";
    }

    @GetMapping("/testDegrade")
    public String testDegrade() {
        return "testDegrade";
    }
}
