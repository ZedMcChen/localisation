/**
 * Copyright Zhiming Chen 2016
 */
package com.zhimingchen.localisation.messagesrc.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zhiming
 *
 */
public class UserAuth {
    @NotEmpty(message="{userauth.error.emailRequired}")
    @Email(message="{userauth.error.emailMalformed}")
    private String email;
    
    @Size(min=8, message="{userauth.error.passwordTooShort}")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
