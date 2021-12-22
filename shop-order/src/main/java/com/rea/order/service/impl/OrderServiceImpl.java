package com.rea.order.service.impl;

import com.rea.mbg.mapper.ShopOrderMapper;
import com.rea.mbg.model.ShopOrder;
import com.rea.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ShopOrderMapper shopOrderMapper;

    @Override
    public void save(ShopOrder order) {
        shopOrderMapper.insert(order);
    }
}
