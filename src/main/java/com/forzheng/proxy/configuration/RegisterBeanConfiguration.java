package com.forzheng.proxy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.forzheng.proxy.filter.TokenFilter;

/**
 * Created by ls on 2018/1/26.
 */
@Configuration
public class RegisterBeanConfiguration {

    //项目启动时实例化TokenFilter并加入spring容器
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
