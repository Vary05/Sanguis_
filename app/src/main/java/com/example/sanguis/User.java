package com.example.sanguis;

public class User {

    private String unique_id;
    private String email;
    private String password;

    public User(String unique_id, String email, String password) {
        this.unique_id = unique_id;
        this.email = email;
        this.password = password;
    }

    public User(String unique_id, String password) {
        this.unique_id = unique_id;
        this.password = password;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
