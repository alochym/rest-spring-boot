# Handle Error Exception.

1. **@ControllerAdvice** handles exceptions globally.
1. **@ExceptionsHandler** together with **@ControllerAdvice** handle exceptions globally.
1. **@ResponseStatus** response status code to client.
1. **ResponseEntityExceptionHandler** can override existing exceptions.

## How to code

1. Define [CustomError][CustomError] class for a blue print template.
1. Define [NotFoundException][NotFoundException] class which is throw an exception when no record of user found.
1. Define an [ErrorExceptionHandler][ErrorExceptionHandler] that handles a not found exception and others exception in future.
1. Check an empty User record(findById) and then throw a new [NotFoundException][UserService].
    - Using `@ControllerAdvice` to handle Exception globally.
    - Using `@ExceptionHandler` to declare an exception for handling.

[UserService]: /src/main/java/com/github/alochym/services/UserService.java
[ErrorExceptionHandler]: /src/main/java/com/github/alochym/errors/ErrorExceptionHandler.java
[NotFoundException]: /src/main/java/com/github/alochym/errors/NotFoundException.java
[CustomError]: /src/main/java/com/github/alochym/errors/CustomError.java