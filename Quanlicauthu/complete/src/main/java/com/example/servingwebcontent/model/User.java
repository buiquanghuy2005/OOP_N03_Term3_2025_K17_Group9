package com.example.servingwebcontent.model;
public class User {
    private String username;
    private String role;
    private String password;
    public User(String username, String role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getRole() {
        return role;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Tên đăng nhập: " + username + ", Vai trò: " + role;
    }   
}
