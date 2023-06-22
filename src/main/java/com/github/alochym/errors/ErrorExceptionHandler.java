package com.github.alochym.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handlerNotFoundException(NotFoundException ex, HttpServletRequest req) {

        CustomError notfound = new CustomError();
        notfound.setMessage(ex.getMessage());
        notfound.setStatusCode(HttpStatus.NOT_FOUND);
        notfound.addError(HttpStatus.NOT_FOUND.getReasonPhrase());
        notfound.setReqURL(req.getServletPath());

        return new ResponseEntity<Object>(notfound, null, notfound.getStatusCode());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<Object> hadnlerServerInternalErrorException(NotFoundException ex, HttpServletRequest req) {

        CustomError serverError = new CustomError();
        serverError.setMessage(ex.getMessage());
        serverError.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        serverError.addError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        serverError.setReqURL(req.getServletPath());

        return new ResponseEntity<Object>(serverError, null, serverError.getStatusCode());
    }
}
