package ru.xaabibas.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xaabibas.test.calculator.Calculator;

@Service
public class CalculateService {
    @Autowired
    private Calculator calculator;

    public String calculateByDays(double salary, int days) {
        return calculator.calculateByDays(salary, days);
    }
}
