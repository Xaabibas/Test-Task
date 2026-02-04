package ru.xaabibas.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xaabibas.test.calculator.Calculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CalculateService {
    @Autowired
    private Calculator calculator;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public BigDecimal calculateByDays(double salary, long days) {
        return calculator.calculateByDays(BigDecimal.valueOf(salary), days);
    }

    public BigDecimal calculateByDates(double salary, String start, String end) {
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        return calculator.calculateByDates(BigDecimal.valueOf(salary), startDate, endDate);
    }
}
