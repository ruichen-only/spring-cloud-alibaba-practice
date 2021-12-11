package com.tidever.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置类
 *
 * @author LiuXin on 2021/11/24
 */
@Configuration
@MapperScan("com.tidever.search.dao")
public class MybatisConfig {
}
