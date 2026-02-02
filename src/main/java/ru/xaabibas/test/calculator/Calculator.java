package ru.xaabibas.test.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public String calculateByDays(double salary, int days) {
        double result = (days / 29.3 * salary / 12);
        return String.format("%.2f", result);
    }
}
