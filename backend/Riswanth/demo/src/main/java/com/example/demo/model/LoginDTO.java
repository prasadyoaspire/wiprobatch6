package com.example.demo.model;

public class LoginDTO {
    private String usernameorEmail;
    private String password;

    public String getUsernameorEmail() {
        return usernameorEmail;
    }

    public void setUsernameorEmail(String usernameorEmail) {
        this.usernameorEmail = usernameorEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
