package com.tidever.search.config;

import com.tidever.common.config.BaseSwaggerConfig;
import com.tidever.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author LiuXin
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.tidever.controller")
                .title("yju搜索系统")
                .description("yju搜索系统相关文档")
                .contactName("LiuXin")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
