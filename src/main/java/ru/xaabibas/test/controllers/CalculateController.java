package ru.xaabibas.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.xaabibas.test.services.CalculateService;

import java.math.BigDecimal;

@RestController
public class CalculateController {
    @Autowired
    private CalculateService service;

    @GetMapping(value = "/calculate", params = {"salary", "days"})
    public ResponseEntity<?> calculate(
            @RequestParam double salary,
            @RequestParam long days
    ) {
        BigDecimal result = service.calculateByDays(salary, days);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/calculate", params = {"salary", "start", "end"})
    public ResponseEntity<?> calculate(
            @RequestParam double salary,
            @RequestParam String start,
            @RequestParam String end
    ) {
        BigDecimal result = service.calculateByDates(salary, start, end);
        return ResponseEntity.ok(result);
    }
}
