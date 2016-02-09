/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.websitelocalisation.singlelang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.zhimingchen.websitelocalisation.common.config.BaseWebConfig;

/**
 * @author zhiming
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.zhimingchen.websitelocalisation.common.controller")
public class WebConfig extends BaseWebConfig {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
}
