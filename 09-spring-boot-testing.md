# Spring Boot Testing

1. Setup
1. Teardown

## How to test

1. `@WebMvcTest` is loaded only Spring MVC components
1. `MockMvc` is performing API calls(HTTP requests) and assertion on the responses.
1. `Mockito` is faked `Service objects` because `@WebMvcTest` does not load the `Service` class.
1. `Object Mapper` to serializes Java Object to JSON and vice versa.
1. `JSONPath` expression to validate JSON in response.

![Spring boot component test](/images/Spring-Boot-components-testing.png)

### Entity Location class

1. [Location.class](/src/main/java/com/github/alochym/entities/Location.java)
    1. `@NotBlank` requires the attribute is not blank.

### Controller Location Layer

1. [LocationAPIController.class](/src/main/java/com/github/alochym/handlers/LocationAPIController.java).
    1. `@Valid` is used to valiation client requests together with `@NotBlank` in [Location.class](/src/main/java/com/github/alochym/entities/Location.java).

### Controller Test Layer

1. Create a [LocationAPIControllerTest.class](/src/test/java/com/github/alochym/LocationAPIControllerTest.java).
1. Using annotations:
    1. `@WebMvcTest` is specified a class to run a test.
    1. `@Autowired` is auto add dependency injection object.
    1. `@MockBean` is auto loaded [LocationService](/src/main/java/com/github/alochym/services/LocationService.java) Object.
    1. `@Test` is running a test

1. Test 400 Bad Request

   ```java
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

    @Test
    public void testAddFailWith400BadRequest() throws Exception {
        Location l = new Location();

        String bodyContent = this.mapper.writeValueAsString(l);

        // to make a HTTP post request to /api/v1/locations.
        this.mockMvc.perform(
                post(END_POINT_PATH).contentType("application/json").content(bodyContent))
                // check response status code.
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    ```

1. Test 201 Create Successful

    ```java
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
    @Test
    public void testAddSuccessWith201() throws Exception {

        Location l = new Location();

        l.setAddress("1900 Federal ct");

        // Create a a Mock for Service Layer.
        // Step 01.
        Mockito.when(this.lsrv.addLocation(l)).thenReturn(l);

        String bodyContent = this.mapper.writeValueAsString(l);

        // to make a HTTP post request to /api/v1/locations.
        // the result is a response from Mockito - Step 01.
        this.mockMvc.perform(
                post(END_POINT_PATH).contentType("application/json").content(bodyContent))
                // check response status code.
                .andExpect(MockMvcResultMatchers.status().isCreated())
                // check the response Header contentType
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
    ```

### Service Test Layer

1. Test business logic
1. TODO

### Respository Test Layer

1. Using `@DataJpaTest`
1. TODO
