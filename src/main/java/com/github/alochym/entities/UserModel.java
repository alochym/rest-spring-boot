package com.github.alochym.entities;

public class UserModel {

    private int id;
    private String username;
    private String password;

    public UserModel(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserModel() {
        // // the default Integer value : 0
        // // the default String value : nul
        // this.id = 0;
        // this.username = null;
        // this.password = null;
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

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", username=" + username + ", password=" + password + "]";
    }

    public Boolean isEmpty() {
        if (this.getId() == 0) {
            return true;
        }
        return false;
    }

    // convert a UserModel to UserResponse
    // knows as Data Transfer Object - DTO.
    public UserResponse toUserResponse() {
        return new UserResponse(this.getId(), this.getUsername());
    }

}
