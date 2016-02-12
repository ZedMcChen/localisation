/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.localisation.fullylocalised.viewresolver;

import java.io.InputStream;
import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * @author zhiming
 *
 */
public class LocaleViewResolver extends InternalResourceViewResolver {
    @Override 
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        String localeViewName = getLocaleViewName(viewName, locale);
        String templateUrl = getPrefix() + localeViewName + getSuffix();
        InputStream templateStream = getServletContext().getResourceAsStream(templateUrl);

        if (templateStream == null) {
            return null;
        }
        return super.resolveViewName(localeViewName, locale);

    }
    private String getLocaleViewName(String viewName, Locale locale) {
        return locale.toString() + "/" + viewName;
    }
}
