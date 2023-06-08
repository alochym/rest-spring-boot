package com.github.alochym.student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentsController {

    @GetMapping // http request GET method.
    public List<String> findAllStudents() {
        String hoanStudent = "{\"id\": 1,\"name\": \"Le Thien Hoan\",\"email\":\"hoanle13@gmail.com\"}";
        String thanhStudent = "{\"id\": 2,\"name\": \"Le Thien Thanh\",\"email\":\"thanhle13@gmail.com\"}";
        return List.of(hoanStudent, thanhStudent);
    }

    @GetMapping("/{id}") // http request GET method by using http request path.
    public String findStudentsById(@PathVariable String id) {
        // public String findStudentsById(@PathVariable("id") String id) {
        return "Get a Student by ID";
    }

    @PostMapping // http request POST method.
    public String createStudents() {
        return "Create a Student";
    }

    @PutMapping("/{id}") // http request PUT method.
    public String updateStudents(@PathVariable String id) {
        return "Update a Student by ID";
    }

    @DeleteMapping("/{id}") // http request DELETE method.
    public String deleteStudents(@PathVariable String id) {
        return "Delete a Student by ID";
    }
}
