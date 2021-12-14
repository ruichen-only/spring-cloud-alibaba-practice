package com.rea.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CRR
 */
@RestController
public class MyAppController {

    @PostMapping("/openApp")
    public String openApp() {
        return "open";
    }
}
