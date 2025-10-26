package com.calculator.string_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroForEmptyString(){
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
        assertEquals(6, calc.add("1,2,3"));
        assertEquals(10, calc.add("1,2,3,4"));
    }

    @Test
    void testNewlineAsDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
        assertEquals(10, calc.add("1\n2\n3,4"));
    }
    
    @Test
    void testCustomDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
        assertEquals(6, calc.add("//|\n1|2|3"));
    }
    
    @Test
    void testNegativeNumbersThrowException() {
        StringCalculator calc = new StringCalculator();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calc.add("1,-2,3,-4");
        });

        assertTrue(exception.getMessage().contains("-2"));
        assertTrue(exception.getMessage().contains("-4"));
    }

    @Test
    void testGetCalledCount() {
        StringCalculator calc = new StringCalculator();

        assertEquals(0, calc.GetCalledCount());

        calc.add("1,2");
        assertEquals(1, calc.GetCalledCount());

        calc.add("3,4,5");
        assertEquals(2, calc.GetCalledCount());
}
}
