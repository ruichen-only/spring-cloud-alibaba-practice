package com.tidever.platform.controller;

import com.tidever.common.api.CommonResult;
import com.tidever.mbg.model.platform.User;
import com.tidever.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author CRR
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody User user) {
        User result = userService.login(user.getUsername(), user.getPassword());
        if(result == null) {
            return CommonResult.failed("错误的用户名或密码");
        }
        return CommonResult.success(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@RequestBody User user) {
        if(userService.register(user) > 0) {
            return CommonResult.success(user);
        }
        return CommonResult.failed("该用户名已存在");
    }
}
