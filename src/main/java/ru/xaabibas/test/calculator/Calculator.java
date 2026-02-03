package ru.xaabibas.test.calculator;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class Calculator {
    public String calculateByDays(double salary, long days) {
        double result = (days / 29.3 * salary / 12);
        return String.format("%.2f", result);
    }

    public String calculateByDates(double salary, LocalDate start, LocalDate end) {
        long days = ChronoUnit.DAYS.between(start, end);
        return calculateByDays(salary, days);
    }
}
