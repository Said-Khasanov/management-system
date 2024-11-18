package org.example.management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler({NoSuchElementException.class})
    public ErrorResponse handle(Exception e) {
        return ErrorResponse
                .builder(e, HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
    }
}
