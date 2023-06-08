# Create RESTful STUDENT.

1. Create `student` package.
1. Create `StudentController.java`.
1. Add `@RestController` annotation.
1. The Path `api/v1/students`.
1. Add `@RequestMapping("api/v1/students)` annotation.
1. Declare a HTTP GET request to get all students.
1. Declare a HTTP GET request to get student by ID.
1. Declare a HTTP POST request to create a student.
1. Declare a HTTP PUT request to update a student.
1. Declare a HTTP DELETE request to delete a student.
1. [Sample StudentController code](src/main/java/com/github/alochym/student/StudentsController.java)

## Using CURL CLI

1. cd curl-data
1. curl.exe -XGET localhost:8080/api/v1/students
1. curl.exe -XGET localhost:8080/api/v1/students/1
1. curl.exe -XPOST localhost:8080/api/v1/students/1 -d @thanh-post.json
1. curl.exe -XPUT localhost:8080/api/v1/students/1 -d @hoan-put.json
1. curl.exe -XDELETE localhost:8080/api/v1/students/1