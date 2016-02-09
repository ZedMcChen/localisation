/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.websitelocalisation.messagesrc.config;

import com.zhimingchen.websitelocalisation.common.config.BaseWebApplicationInitializer;

/**
 * @author zhiming
 *
 */
public class WebApplicationInitializer extends BaseWebApplicationInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }
}
