package com.github.alochym.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;

/*
 * the field "trace" is present in ErrorException 
 * if you have "spring-boot-devtools" in your dependencies. 
*/

public class CustomError {
    private String message;
    private String reqURL;
    private int statusCode;
    private List<String> customErrors;

    public CustomError() {
        this.customErrors = new ArrayList<>();
    };

    public CustomError(String message, String reqURL, HttpStatusCode statusCode) {
        this.message = message;
        this.reqURL = reqURL;
        this.statusCode = statusCode.value();
    }

    public String getReqURL() {
        return reqURL;
    }

    public void setReqURL(String reqURL) {
        this.reqURL = reqURL;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode.value();
    }

    public List<String> getCustomErrors() {
        return customErrors;
    }

    public void setCustomErrors(List<String> customErrors) {
        this.customErrors = customErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addError(String message) {
        this.customErrors.add(message);
    }
}
