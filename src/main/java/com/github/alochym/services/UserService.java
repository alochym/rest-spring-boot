package com.github.alochym.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.alochym.entities.UserModel;
import com.github.alochym.errors.NotFoundException;
import com.github.alochym.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> findAll() {

        ArrayList<UserModel> result = this.userRepository.findAll();
        // should be doing Response DTO.
        /*
         * ArrayList<UserResponse> uResponse = new ArrayList<UserResponse>;
         * 
         * for (UserModel u : result) {
         * uResponse.add(u.toUserResponse());
         * }
         * 
         * return new ResponseEntity<>(uResponse, this.customHttpHeaders(),
         * HttpStatus.OK);
         */
        return new ResponseEntity<>(result, this.customHttpHeaders(), HttpStatus.OK);
    }

    public ResponseEntity<?> findById(int id, HttpServletRequest request) {

        UserModel result = this.userRepository.findById(id);

        // check User is not found.
        if (result.isEmpty()) {
            logger.info("User ID: {} is not found", id);
            // should be doing Response DTO.
            // return ResponseEntity.notFound().build();
            throw new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }

        // should be doing Response DTO. result.toUserResponse().
        return new ResponseEntity<>(result, this.customHttpHeaders(), HttpStatus.OK);
    }

    public ResponseEntity<?> findByEmail(String e, HttpServletRequest request) {

        UserModel result = this.userRepository.findByEmail(e);

        // check User is not found.
        if (result.isEmpty()) {
            logger.info("User Name: {} is not found", e);
            // should be doing Response DTO.
            // return ResponseEntity.notFound().build();
            throw new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }

        // should be doing Response DTO. result.toUserResponse().
        return new ResponseEntity<>(result, this.customHttpHeaders(), HttpStatus.OK);
    }

    public ResponseEntity<?> create(UserModel u) {
        logger.info(u.toString());

        // should be doing Response DTO. this.userRepository.save(u).toUserResponse().
        return new ResponseEntity<>(this.userRepository.save(u), this.customHttpHeaders(), HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateById(UserModel u, HttpServletRequest request) {

        UserModel temp = this.userRepository.update(u);

        // check User is not found.
        if (temp.isEmpty()) {
            logger.info("Update User ID: {} is not found", u.getId());
            // should be doing Response DTO.
            // return ResponseEntity.notFound().build();
            return new ResponseEntity<>(null, this.customHttpHeaders(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(null, this.customHttpHeaders(), HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> deleteById(int id, HttpServletRequest request) {

        UserModel result = this.userRepository.delete(id);

        // check User is not found.
        if (result.isEmpty()) {
            logger.info("Delete User ID: {} is not found", id);
            // should be doing Response DTO.
            // return ResponseEntity.notFound().build();
            return new ResponseEntity<>(null, this.customHttpHeaders(), HttpStatus.NOT_FOUND);
        }

        // should be doing Response DTO. result.toUserResponse().
        return new ResponseEntity<>(result, this.customHttpHeaders(), HttpStatus.ACCEPTED);
    }

    private HttpHeaders customHttpHeaders() {
        // custom headers response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Server", "Spring Boot RESTful API");
        return headers;
    }
}
