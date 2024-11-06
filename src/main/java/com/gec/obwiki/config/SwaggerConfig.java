package com.gec.obwiki.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        // 1. 创建 Swagger 配置对象
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        // 设置 API 信息
        ApiInfo info = new ApiInfoBuilder()
                .title("海洋生物知识库系统")
                .description("用于管理和查询海洋生物知识的API接口")
                .version("1.0")
                .build();
        docket.apiInfo(info);

        // 2. 配置显示在 Swagger 页面上的方法
        docket = docket.select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();

        // 3. Swagger 支持 JWT
        ApiKey apiKey = new ApiKey("token", "token", "header");
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        securitySchemes.add(apiKey);
        docket.securitySchemes(securitySchemes);

        // 4. 设置令牌作用域为全局
        AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] scopes = {scope};
        SecurityReference reference = new SecurityReference("token", scopes);
        List<SecurityReference> refList = new ArrayList<>();
        refList.add(reference);

        SecurityContext context = SecurityContext.builder().securityReferences(refList).build();
        List<SecurityContext> cxtList = new ArrayList<>();
        cxtList.add(context);

        docket.securityContexts(cxtList);

        return docket;
    }
}
