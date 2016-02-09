/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.websitelocalisation.singlelang.controller;

import static  java.net.URLEncoder.encode;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.zhimingchen.websitelocalisation.singlelang.controller.LoginController;

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
        this.mockMvc.perform(get("/login"))
                    .andExpect(view().name("loginForm"));
    }

    @Test
    public void shouldLoginUserWithGoodCredential() throws Exception {
        String email = "me@email.com";
        this.mockMvc.perform(post("/login")
                             .param("email", email)
                             .param("password", "mypassword"))
                    .andExpect(model().errorCount(0))
                    .andExpect(redirectedUrl("/hello/" + encode(email, "UTF-8")));
    }
    
    @Test
    public void shouldFailToLoginUserWithBadCredential() throws Exception {
        this.mockMvc.perform(post("/login")
                             .param("email", "meemail.com")
                             .param("password", "mypass"))
                    .andExpect(model().errorCount(2))
                    .andExpect(model().attributeHasFieldErrors("userAuth", "email", "password"))
                    .andExpect(view().name("loginForm"));
    }
    
    @Test
    public void shouldRenderGreetingsMsg() throws Exception {
        this.mockMvc.perform(get("/hello/friend"))
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
