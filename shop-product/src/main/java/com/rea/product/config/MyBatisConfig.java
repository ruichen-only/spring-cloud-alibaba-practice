package com.rea.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.tidever.mbg.mapper.platform", "com.tidever.mbg.mapper.model.platform"})
public class MyBatisConfig {
}
