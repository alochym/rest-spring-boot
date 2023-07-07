package com.github.alochym.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class Location {
    @NotBlank // requires the address attribute is not blank
    private String address;

    public Location() {
    }

    public Location(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
