package com.example.prashanjeet.firebase;

/**
 * Created by prajjwal-ubuntu on 26/1/19.
 */
public class User {
    private String name,mobile,email,username;
    private String id;
    public User(){

    }

    public User(String name, String mobile, String email, String id,String username) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.id = id;
        this.username=username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}