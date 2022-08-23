package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {



    /**
     * 设置跨域访问
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods(CorsConfiguration.ALL)
                .allowCredentials(true)//设置是否允许客户端发送cookie信息。默认是false
                .maxAge(3600); // 1小时内不需要再预检（发OPTIONS请求）
    }

//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    /**
//     * 设置登录拦截
//     *
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
////                .addPathPatterns("/user/getList");
//        .addPathPatterns("/**").excludePathPatterns("/login");
//
//    }
}
