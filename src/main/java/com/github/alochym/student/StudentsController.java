package com.github.alochym.student;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentsController {

    private Logger logger = LoggerFactory.getLogger(StudentsController.class);

    // full URI "api/v1/student/"
    @RequestMapping(value = "/", method = RequestMethod.GET) // http request GET method.
    public ResponseEntity<?> findAllStudents() {
        String hoanStudent = "{\"id\": 1,\"name\": \"Le Thien Hoan\",\"email\":\"hoanle13@gmail.com\"}";
        String thanhStudent = "{\"id\": 2,\"name\": \"Le Thien Thanh\",\"email\":\"thanhle13@gmail.com\"}";
        List<String> result = new ArrayList<>();
        result.add(hoanStudent);
        result.add(thanhStudent);

        // custom headers response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Server", "Spring Boot RESTful API");

        // logging custom headers
        logger.error(headers.toString());
        logger.warn(headers.toString());
        logger.info(headers.toString());
        logger.debug(headers.toString());
        logger.trace(headers.toString());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}") // http request GET method by using http request path.
    public ResponseEntity<?> findStudentsById(@PathVariable Integer id) {
        // public String findStudentsById(@PathVariable("id") String id) {

        // custom headers response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Server", "Spring Boot RESTful API");

        // Test response 404 - not found
        if (id == 3) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>("Get a Student by ID", headers, HttpStatus.OK);
    }

    @PostMapping("/") // http request POST method.
    public ResponseEntity<?> createStudents() {
        // custom headers response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Server", "Spring Boot RESTful API");

        return new ResponseEntity<>("Create a Student", HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // http request PUT method.
    public ResponseEntity<?> updateStudents(@PathVariable Integer id) {
        // custom headers response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Server", "Spring Boot RESTful API");

        // Test response 404 - not found
        if (id == 3) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>("Update a Student by ID", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}") // http request DELETE method.
    public ResponseEntity<?> deleteStudents(@PathVariable Integer id) {
        // custom headers response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Server", "Spring Boot RESTful API");

        // Test response 404 - not found
        if (id == 3) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>("Delete a Student by ID", HttpStatus.ACCEPTED);
    }
}
