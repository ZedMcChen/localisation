/**
 * Copyright Zhiming Chen 2016
 */
package com.zedmcchen.websitelocalisation.singlelang.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.zedmcchen.websitelocalisation.singlelang.controller.LoginController;

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
	public void shouldRedirectFromHometoLogin() throws Exception {
		this.mockMvc.perform(get("/home"))
		       		.andExpect(redirectedUrl("/login"));
	}
	
	@Test
	public void shouldRedirectFromToptoLogin() throws Exception {
		this.mockMvc.perform(get("/"))
		       		.andExpect(view().name("redirect:/login"));
	}
	
	@Test
	public void shouldReturnLoginFormView() throws Exception {
		this.mockMvc.perform(get("/login"))
		       		.andExpect(view().name("loginForm"));
	}
}
