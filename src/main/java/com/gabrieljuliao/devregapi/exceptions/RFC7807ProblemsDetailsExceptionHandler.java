package com.gabrieljuliao.devregapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RFC7807ProblemsDetailsExceptionHandler {
    @ExceptionHandler(value = DeveloperNotFoundException.class)
    public ResponseEntity<?> developerNotFoundHandler(DeveloperNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(
                new RFC7807ProblemsDetails("Developer not found", notFound.value(), "Requested developer does not exist"),
                notFound
        );
    }
}
