package com.example.techblog.models;

public class User {
    private int id;
    private String fullname;
    private String email;
    private String password;
    private String createdAt;

    public User() {
    }

    public User(int id, String fullname, String email, String password, String createdAt) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
