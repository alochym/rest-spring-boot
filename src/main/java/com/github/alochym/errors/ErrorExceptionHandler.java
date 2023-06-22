package com.github.alochym.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handlerNotFoundException(NotFoundException ex, HttpServletRequest req) {

        CustomError notfound = new CustomError();
        notfound.setMessage(ex.getMessage());
        notfound.setStatusCode(HttpStatus.NOT_FOUND);
        notfound.addError(HttpStatus.NOT_FOUND.getReasonPhrase());
        notfound.setReqURL(req.getRequestURI());

        return new ResponseEntity<Object>(notfound, null, notfound.getStatusCode());
    }
}
