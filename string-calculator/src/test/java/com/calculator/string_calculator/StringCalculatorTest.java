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
    
    
}
