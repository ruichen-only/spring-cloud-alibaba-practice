package com.rea.product.service.impl;

import com.rea.mbg.mapper.ShopProductMapper;
import com.rea.mbg.model.ShopProduct;
import com.rea.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author CRR
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ShopProductMapper shopProductMapper;

    @Override
    @RequestMapping(value = "findByPid", method = RequestMethod.POST)
    public ShopProduct findByPid(Integer pid) {
        log.info(">>-----远程调用商品服务查找商品");
        return shopProductMapper.selectByPrimaryKey(pid);
    }
}
