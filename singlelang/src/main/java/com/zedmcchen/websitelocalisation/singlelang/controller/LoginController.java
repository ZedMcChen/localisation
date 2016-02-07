/**
 * Copyright Zhiming Chen 2016
 */
package com.zedmcchen.websitelocalisation.singlelang.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zedmcchen.websitelocalisation.singlelang.model.UserAuth;

import static  java.net.URLEncoder.encode;

import java.io.UnsupportedEncodingException;

/**
 * @author zhiming
 *
 */

@Controller
public class LoginController {
    
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String showLoginForm(Model model) {
        UserAuth userAuth = new UserAuth();
        model.addAttribute(userAuth);
        return "loginForm";
    }

    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String doLogin(@Valid UserAuth userAuth, Errors errors) throws UnsupportedEncodingException {
        if (errors.hasErrors()) {
            return "loginForm";
        }
        
        String email = userAuth.getEmail();
        return "redirect:/hello/" + encode(email, "UTF-8");
    }

    @RequestMapping(value = "/hello/{email}", method=RequestMethod.GET)
    public String showGreetingsMessage(@PathVariable("email") String email, Model model) {
        model.addAttribute("email", email);
        return "hello";
    }

    @RequestMapping(value = {"/", "home"}, method=RequestMethod.GET)
    public String siteHome() {
        return "redirect:/login";
    }

}
