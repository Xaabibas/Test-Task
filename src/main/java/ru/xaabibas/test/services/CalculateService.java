package ru.xaabibas.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xaabibas.test.calculator.Calculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CalculateService {
    @Autowired
    private Calculator calculator;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String calculateByDays(double salary, long days) {
        return calculator.calculateByDays(salary, days);
    }

    public String calculateByDates(double salary, String start, String end) {
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException();
        }
        return calculator.calculateByDates(salary, startDate, endDate);
    }
}
