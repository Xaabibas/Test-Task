package ru.xaabibas.test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ResponseEntity<?> unprocessableEntity(UnsatisfiedServletRequestParameterException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Map.of("message", "Недостаточно параметров для расчета отпускных"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> unprocessableEntity(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Map.of("message", "Дата начала отпуска должна быть раньше его конца"));
    }

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<?> unprocessableEntity(DateTimeException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Map.of("message", "Некоректный формат дат. Введите дату в формате dd.MM.yyyy"));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Ошибка сервера"));
    }
}
