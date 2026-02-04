package ru.xaabibas.test.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testCalculateByDays() {
        BigDecimal salary = BigDecimal.valueOf(120000);
        long days = 14;

        BigDecimal result = calculator.calculateByDays(salary, days);

        assertEquals(BigDecimal.valueOf(4778.16), result);
    }

    @Test
    void testRoundResultToTwoDigits() {
        BigDecimal salary = BigDecimal.valueOf(365.73432);
        long days = 1;

        BigDecimal result = calculator.calculateByDays(salary, days);

        assertEquals(BigDecimal.valueOf(1.04), result);
    }

    @Test
    void testCalculateByDates() {
        BigDecimal salary = BigDecimal.valueOf(120000);
        LocalDate start = LocalDate.of(2026, 1, 1);
        LocalDate end = LocalDate.of(2026, 1, 15);

        BigDecimal result = calculator.calculateByDates(salary, start, end);

        assertEquals(BigDecimal.valueOf(4778.16), result);
    }

    @Test
    void testEqualsDates() {
        BigDecimal salary = BigDecimal.valueOf(120000);
        LocalDate date = LocalDate.of(2026, 1, 1);

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateByDates(salary, date, date)
        );
    }

    @Test
    void testEndBeforeStart() {
        BigDecimal salary = BigDecimal.valueOf(120000);
        LocalDate start = LocalDate.of(2026, 1, 1);
        LocalDate end = LocalDate.of(2026, 1, 15);

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateByDates(salary, end, start)
        );
    }

    @Test
    void testNotPositiveSalary() {
        BigDecimal salary = BigDecimal.ZERO;
        long days = 10;

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateByDays(salary, days)
        );
    }

    @Test
    void testNotPositiveDays() {
        BigDecimal salary = BigDecimal.valueOf(120000);
        long days = 0;

        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateByDays(salary, days)
        );
    }


}
