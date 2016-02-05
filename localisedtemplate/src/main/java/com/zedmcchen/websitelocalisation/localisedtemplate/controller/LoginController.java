/**
 * Copyright Zhiming Chen 2016
 */
package com.zedmcchen.websitelocalisation.localisedtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhiming
 *
 */

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String showLoginForm() {
        return "loginForm";
    }

}
