package com.rea.product.service;

import com.rea.mbg.model.ShopProduct;

/**
 * @author CRR
 */
public interface ProductService {
    /**
     * 根据商品id取得商品信息
     * @param pid
     * @return
     */
    ShopProduct findByPid(Integer pid);
}
