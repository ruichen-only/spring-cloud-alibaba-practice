package com.rea.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.rea.mbg.mapper.platform", "com.rea.mbg.mapper.model.platform"})
public class MyBatisConfig {
}
