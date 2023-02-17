/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class Account {
    
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    
    private int id;
    private String username;
    private String password;
    private String displayname;
    private String email;
    private String phone;
    private String role;

    public Account() {
    }

    public Account(int id, String username, String password, String displayname, String email, String phone, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayname = displayname;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", username=" + username + ", password=" + password + ", displayname=" + displayname + ", email=" + email + ", phone=" + phone + ", role=" + role + '}';
    }
    
    
    
    
}
