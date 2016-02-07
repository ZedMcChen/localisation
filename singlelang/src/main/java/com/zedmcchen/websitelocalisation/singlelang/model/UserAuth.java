/**
 * Copyright Zhiming Chen 2016
 */
package com.zedmcchen.websitelocalisation.singlelang.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zhiming
 *
 */
public class UserAuth {
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    @Size(min=8, max=256)
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
