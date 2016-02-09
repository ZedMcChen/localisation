/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.websitelocalisation.messagesrc.controller;

import static  java.net.URLEncoder.encode;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.zhimingchen.websitelocalisation.messagesrc.controller.LoginController;

/**
 * @author zhiming
 *
 */

public class LoginControllerTest {
	private MockMvc mockMvc;
	
	@Before
	public void setup() {		
		LoginController controller = new LoginController();
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void shouldReturnLoginFormView() throws Exception {
		this.mockMvc.perform(get("/login?land=en"))
		       		.andExpect(view().name("loginForm"));
	}

    @Test
    public void shouldLoginUserWithGoodCredential() throws UnsupportedEncodingException, Exception {
        String email = "good@email.com";
        this.mockMvc.perform(post("/login")
                             .param("email", email)
                             .param("password", "mypassword"))
                    .andExpect(model().hasNoErrors())
                    .andExpect(redirectedUrl("/hello/" + encode(email, "UTF-8")));
    }

    @Test
    public void shouldFailToLoginUserWithBadCredential() throws UnsupportedEncodingException, Exception {
        this.mockMvc.perform(post("/login")
                             .param("email", "jadf.com")
                             .param("password", "mypass"))
                    .andExpect(model().errorCount(2))
                    .andExpect(model().attributeHasFieldErrors("userAuth", "email", "password"))
                    .andExpect(view().name("loginForm"));
    }

    @Test
    public void shouldRenderGreetingsMsg() throws Exception {
        this.mockMvc.perform(get("/hello/friend?lang=en"))
                    .andExpect(model().attribute("email", "friend"))
                    .andExpect(view().name("hello"));
    }

    @Test
    public void shouldRedirectFromHometoLogin() throws Exception {
        this.mockMvc.perform(get("/home"))
                    .andExpect(redirectedUrl("/login"));
    }
    
    @Test
    public void shouldRedirectFromToptoLogin() throws Exception {
        this.mockMvc.perform(get("/"))
                    .andExpect(view().name("redirect:/login"));
    }
    
}
