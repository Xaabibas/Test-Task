package ru.xaabibas.test.calculator;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class Calculator {
    private static final BigDecimal AVERAGE_DAYS = BigDecimal.valueOf(29.3);

    public BigDecimal calculateByDays(BigDecimal salary, long days) {
        if (salary.intValue() <= 0 || days <= 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal result = salary.multiply(BigDecimal.valueOf(days))
                .divide(AVERAGE_DAYS, 10, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_UP);
        return result;
    }

    public BigDecimal calculateByDates(BigDecimal salary, LocalDate start, LocalDate end) {
        if (end.isBefore(start)) {
            throw new IllegalArgumentException();
        }
        long days = ChronoUnit.DAYS.between(start, end);
        return calculateByDays(salary, days);
    }
}
