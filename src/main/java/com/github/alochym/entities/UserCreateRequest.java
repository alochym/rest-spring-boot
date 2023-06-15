package com.github.alochym.entities;

import java.util.Random;

public class UserCreateRequest {
    private String username;
    private String password;

    public UserCreateRequest(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "UserCreateRequest [username=" + username + ", password=" + password + "]";
    }

    // convert a UserCreateRequest to UserModel
    // Using for In memory database only.
    // knows as Data Transfer Object - DTO.
    public UserModel toUserModel() {
        // Random Id for User.
        Random r = new Random();
        int id = r.nextInt(1000);
        return new UserModel(id, this.getUsername(), this.password);
    }
}
