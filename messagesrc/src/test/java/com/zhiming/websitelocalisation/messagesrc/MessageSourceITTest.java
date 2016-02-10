/**
 * Copyright Zhiming Chen 2016
 */
package com.zhiming.websitelocalisation.messagesrc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.zhimingchen.websitelocalisation.messagesrc.config.WebConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Locale;


/**
 * @author zhiming
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=WebConfig.class)
public class MessageSourceITTest {
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private WebApplicationContext context;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void shouldForwardToTheCorrectJsp() throws Exception {
        
        this.mockMvc.perform(get("/login?lang=fr"))
                    .andExpect(forwardedUrl("/WEB-INF/views/loginForm.jsp"));
        
    }

    @Test
    public void shouldGetCorrectLocale() throws Exception {
        assertThat(messageSource.getMessage("login.error.emailRequired", null, new Locale("fr")), is("Email est requis"));
        assertThat(messageSource.getMessage("label.login", null, new Locale("fr")), is("Connexion"));
    }
    
}
