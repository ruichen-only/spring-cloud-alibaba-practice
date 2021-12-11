package com.tidever.platform.controller;

import com.tidever.common.api.CommonResult;
import com.tidever.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/doDelete", method = RequestMethod.POST)
    public CommonResult doDelete(@RequestParam long id) {
        return CommonResult.success(userService.deleteUser(id));
    }

    @RequestMapping(value = "/doEdit", method = RequestMethod.POST)
    public CommonResult doEdit(@RequestParam long id,
                               @RequestParam String username,
                               @RequestParam String password) {
        return CommonResult.success(userService.update(id, username, password));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public CommonResult getAll() {
        return CommonResult.success(userService.getAll());
    }
}
