package com.studybook.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 1. @Configuration 系统可以自己读取


 测试方法， 两种结果不一样
 1 任意地址
 2 controller 发生异常


 * Created by HealerJean on 2017/4/5.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }



}
