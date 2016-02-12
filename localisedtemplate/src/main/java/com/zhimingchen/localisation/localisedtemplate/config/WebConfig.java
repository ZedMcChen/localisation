/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.localisation.localisedtemplate.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.zhimingchen.localisation.localisedtemplate.viewresolver.LocaleViewResolver;

/**
 * @author zhiming
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.zhimingchen.localisation.localisedtemplate.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
    
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

    // enable default handler 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    // static content location
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
}

