package com.example.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  // 声明这是一个配置类
@EnableSwagger2 // 允许使用swagger2
public class SwaggerConfig {
    @Bean
    public Docket loginInConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true) // 可以和配置文件联合使用限只有在开发环境生成该Api文档
                .apiInfo(apiInfo()) // 设置api文档的详细信息
                .select()//配置扫描信息
                //配置扫描方式 basePackage：扫描包 all:全扫描 none：不扫描
//                .apis(RequestHandlerSelectors.basePackage("com.example.phenocam"))
                //过滤掉admin路径下的所有页面
                .apis(RequestHandlerSelectors.any())
//                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                //过滤掉所有error或error.*页面
                .paths(Predicates.not(PathSelectors.regex("/error.*"))) // 注意所有的web项目会有一个默认的error请求
                .build();
    }

    /**
     * 返回Api的具体信息
     * @return
     */
    private ApiInfo apiInfo(){

        return new ApiInfoBuilder()
                .title("仿掘金")
//                .description("")
                .version("1.0")
                .contact(new Contact("ZW", "http://localhost:8088/swagger-ui.html", "2213160043@qq.com")) //作者
                .build();
    }

}
