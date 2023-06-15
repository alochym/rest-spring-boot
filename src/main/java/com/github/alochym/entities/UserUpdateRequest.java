package com.github.alochym.entities;

public class UserUpdateRequest {
    private String username;
    private String password;

    public UserUpdateRequest(String username, String password) {
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

    // convert a UserUpdateRequest to UserModel
    // knows as Data Transfer Object - DTO.
    public UserModel toUserModel(int id) {
        return new UserModel(id, this.getUsername(), this.password);
    }
}
