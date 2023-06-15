# 3 Tiers Architecture.

- [3-tiers architecture Microsoft](https://learn.microsoft.com/en-us/dotnet/architecture/modern-web-apps-azure/common-web-application-architectures#traditional-n-layer-architecture-applications).
- [Reference docs](3-tier-REST-Services.pdf).
- [All docs](https://dsrl.eu/courses/sd/materials/lectures/).
- [Course info](https://dsrl.eu/courses/sd/).

## HTTP Request and HTTP Response Guide.

1. [HTTP](https://developer.mozilla.org/en-US/docs/Web/HTTP).
1. [HTTP Headers](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers).
1. [HTTP Request Methods](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods).
1. [HTTP Status Response Codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status).
    1. Informational responses (100 – 199).
    1. [Successful responses (200 – 299)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses).
    1. Redirection messages (300 – 399).
    1. [Client error responses (400 – 499)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses).
    1. [Server error responses (500 – 599)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#server_error_responses).
1. [Reference docs](HTTP-request-response.pdf).

## Project structure.

```bash
└───com
    └───github
        └───alochym
            ├───entities
            │    ├───UserCreateRequest.java
            │    ├───UserModel.java
            │    ├───UserResponse.java # Response DTO Object.
            │    └───UserUpdateRequest.java
            ├───errors
            ├───handlers
            │    └───UserController.java
            ├───repositories
            │    └───UserRepository.java
            └───services
                 └───UserService.java
```

- **entities**: An Java Object represents Table database(***sometime call Model***).
- **error**: folder define all errors for spring boot app.
- **handlers**: Handle HTTP RESTful requests(***sometime call Controller***).
- **repository**: Implement Data Access Object(DAO) - CRUD interactive to Database server.
- **services**: Business logic layer.

### HTTP Request and HTTP Response flow.

![HTTP Request and HTTP Response Flow](/images/request-response-flow.png).

### How to code.

#### Step 01 - Define Entity Objects.

- [UserModel.java](/src/main/java/com/github/alochym/entities/UserModel.java) - The table schema.
- [UserCreateRequest.java](/src/main/java/com/github/alochym/entities/UserCreateRequest.java) - The client requests to create a user.
- [UserUpdateRequest.java](/src/main/java/com/github/alochym/entities/UserUpdateRequest.java) - The client requests to update a user to request url `/api/v1/users`.

#### Step 02 - Define Repository Objects.

- [UserRepository.java](/src/main/java/com/github/alochym/repositories/UserRepository.java) - ***Interacting to database server or in-memory to act CRUD operation***.

#### Step 03 - Define Service Objects.

- [UserService.java](/src/main/java/com/github/alochym/services/UserService.java):
    1. ***Doing business logic for entire CRUD operation of USER***.
    1. Doing a Response DTO progress.

#### Step 04 - Define Handler Objects.

- [UserController.java](/src/main/java/com/github/alochym/handlers/UserController.java):
    1. The entry point for client to interact to. 
    1. Convert [UserCreateRequest Object](/src/main/java/com/github/alochym/entities/UserCreateRequest.java) to [UserModel Object](/src/main/java/com/github/alochym/entities/UserModel.java) for `creating` a new User. As known Data Transfer Object(DTO).
    1. Convert [UserUpdateRequest Object](/src/main/java/com/github/alochym/entities/UserUpdateRequest.java) to [UserModel Object](/src/main/java/com/github/alochym/entities/UserModel.java) for `updating` a User. As known Data Transfer Object(DTO).

## Hexagonal Architecture.

- [Reference docs](Understanding%20Hexagonal%20Architecture%20With%20a%20Spring%20Boot%20Implementation%20_%20by%20Ram%C3%B3n%20Bail%C3%A9n%20_%20Better%20Programming.pdf).

![Hexagonal architecture](/images/hexagonal-architecture.jpg).