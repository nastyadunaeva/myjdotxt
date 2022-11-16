package com.todotxt.todotxttouch.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CursorPositionCalculatorTest {

    @Test
    public void testCalculatePriorValueNull() {
        int priorCursorPosition = 1;
        String priorValue = null;
        String newValue = "test";

        int result = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

        assertEquals(4, result);
    }

    @Test
    public void testCalculateNewValueNull() {
        int priorCursorPosition = 1;
        String priorValue = "";
        String newValue = null;

        int result = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

        assertEquals(0, result);
    }

    @Test
    public void testCalculateCorrect() {
        int priorCursorPosition = 1;
        String priorValue = "test";
        String newValue = "test test";

        int result = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

        assertEquals(6, result);
    }

    @Test
    public void testCalculateNewStringShorter() {
        int priorCursorPosition = 1;
        String priorValue = "test test";
        String newValue = "test";

        int result = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

        assertEquals(0, result);
    }

    @Test
    public void testCalculateCursorLongerNewString() {
        int priorCursorPosition = 5;
        String priorValue = "test";
        String newValue = "test test";

        int result = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

        assertEquals(9, result);
    }
}

