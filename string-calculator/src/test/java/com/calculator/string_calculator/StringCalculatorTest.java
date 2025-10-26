package com.calculator.string_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    
}
