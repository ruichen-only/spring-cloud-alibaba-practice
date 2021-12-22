package com.rea.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author CRR
 */
@Configuration
@MapperScan({"com.rea.mbg.mapper", "com.rea.mbg.mapper.model"})
public class MyBatisConfig {
}
