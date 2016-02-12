/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.localisation.localisedtemplate.config;

import com.zhimingchen.localisation.common.config.BaseWebApplicationInitializer;

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
