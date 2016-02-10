/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.websitelocalisation.localisedtemplate.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.zhimingchen.websitelocalisation.common.config.BaseWebConfig;
import com.zhimingchen.websitelocalisation.localisedtemplate.viewresolver.LocaleViewResolver;

/**
 * @author zhiming
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.zhimingchen.websitelocalisation.common.controller")
public class WebConfig extends BaseWebConfig {
    
    @Bean
    public ViewResolver localeViewResolver() {
        LocaleViewResolver resolver = new LocaleViewResolver();
        
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(0);
        resolver.setExposeContextBeansAsAttributes(true);
        
        return resolver;
    }
    
    @Bean
    public ViewResolver fallbackViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(1);
        resolver.setExposeContextBeansAsAttributes(true);
        
        return resolver;
    }
    
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("en", "GB"));
        return resolver;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor () {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}

