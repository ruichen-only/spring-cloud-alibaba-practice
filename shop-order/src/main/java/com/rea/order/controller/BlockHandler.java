package com.rea.order.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CRR
 */
public class BlockHandler {
    public static String handleException(BlockException be) {
        Map<String, Object> map = new HashMap<>();
        if(be instanceof FlowException) {
            map.put("code", -1);
            map.put("msg", "系统限流，请稍等");
        } else if(be instanceof DegradeException) {
            map.put("code", -2);
            map.put("msg", "降级了");
        }
        return JSON.toJSONString(map);
    }

    public static String handlerError() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", "系统异常");
        return JSON.toJSONString(map);
    }
}
