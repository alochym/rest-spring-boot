package com.github.alochym.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.alochym.entities.UserCreateRequest;
import com.github.alochym.entities.UserUpdateRequest;
import com.github.alochym.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        return this.userService.findById(id);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findByEmail(@RequestParam(name = "email", required = true) String email) {

        logger.info("Find an Email: {}", email);

        return this.userService.findByEmail(email);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateRequest reqCreate) {

        logger.info(reqCreate.toString());

        return this.userService.create(reqCreate.toUserModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") int id, @RequestBody UserUpdateRequest reqUpdate) {

        logger.info(reqUpdate.toString());

        return this.userService.updateById(reqUpdate.toUserModel(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        return this.userService.deleteById(id);
    }
}
