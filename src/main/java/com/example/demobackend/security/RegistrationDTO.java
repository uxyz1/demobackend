package com.example.demobackend.security;

import javax.validation.constraints.Size;

/**
 * RegistrationDTO is a Data Transfer Object for registration purposes
 */
public class RegistrationDTO {

    @Size(min = 3, max = 50)
    private  String username;

    @Size(min = 5)
    private  String password1;
    private String password2;

    public RegistrationDTO(String username, String password1, String password2) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword1() {
        return password1;
    }
    public String getPassword2() {
        return password2;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
