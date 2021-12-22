package com.rea.order.service;

import com.rea.mbg.model.ShopOrder;

/**
 * @author CRR
 */
public interface OrderService {
    /**
     * 下单
     * @param order
     */
    void save(ShopOrder order);
}
