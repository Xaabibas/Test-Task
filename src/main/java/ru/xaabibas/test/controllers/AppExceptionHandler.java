package ru.xaabibas.test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleError(Exception e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Map.of("message", "некоректные данные"));
    }
}
