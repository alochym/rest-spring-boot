# Response HTTP status code & Custom HTTP Headers.

1. Get all students http request, that should return http status code `200 OK`.
1. Create a student http request, that should return http status code `201 Created` 
1. Get a student http request, that should return http status code `200 OK`.
1. Put a student http request, that should return http status code `204 No Content`.
1. Delete a student http request, that should return http status code `202 Accepted`.
1. Get a not found student http request, that should return http status code `404 Not Found`.

## How to Response HTTP status code

- Using `org.springframework.http.ResponseEntity` to return a response to client.

### Get all students

  ```java
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    ...
    @RequestMapping(value = "/", method = RequestMethod.GET) // http request GET method.
    public ResponseEntity<?> findAllStudents() {
        String hoanStudent = "{\"id\": 1,\"name\": \"Le Thien Hoan\",\"email\":\"hoanle13@gmail.com\"}";
        String thanhStudent = "{\"id\": 2,\"name\": \"Le Thien Thanh\",\"email\":\"thanhle13@gmail.com\"}";
        List<String> result = new ArrayList<>();
        result.add(hoanStudent);
        result.add(thanhStudent);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
  ```


### Get a student

  ```java
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    ...
    @GetMapping("/{id}") // http request GET method by using http request path.
    public ResponseEntity<?> findStudentsById(@PathVariable String id) {
        // public String findStudentsById(@PathVariable("id") String id) {
        return new ResponseEntity<>("Get a Student by ID", HttpStatus.OK);
    }
  ```

### Create a student

  ```java
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    ...
    @PostMapping // http request POST method.
    public ResponseEntity<?> createStudents() {
        return new ResponseEntity<>("Create a Student", HttpStatus.CREATED);
    }
  ```

### Put a student

  ```java
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    ...
    @PutMapping // http request POST method.
    public ResponseEntity<?> createStudents() {
        return new ResponseEntity<>("Create a Student", HttpStatus.NO_CONTENT);
    }
  ```

### Delete a student

  ```java
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    ...
    @DeleteMapping // http request POST method.
    public ResponseEntity<?> createStudents() {
        return new ResponseEntity<>("Create a Student", HttpStatus.ACCEPTED);
    }
  ```

## Add Custom HEADER Response

- Using HttpHeaders to create `a http headers`

  ```java
    import org.springframework.http.HttpHeaders;
    ...
    @GetMapping("/{id}") // http request GET method by using http request path.
    public ResponseEntity<?> findStudentsById(@PathVariable String id) {
        // public String findStudentsById(@PathVariable("id") String id) {

        // custom headers response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Server", "Spring Boot RESTful API");

        return new ResponseEntity<>("Get a Student by ID", headers, HttpStatus.OK);
    }
  ```

## 404 NOT FOUND Exception

### Get a student

   ```java
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
   ```

### Put a student

   ```java
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
   ```

### Delete a student

   ```java
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
   ```
