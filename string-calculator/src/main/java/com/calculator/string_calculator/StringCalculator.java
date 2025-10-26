package com.calculator.string_calculator;

public class StringCalculator {
    public int add(String numbers){
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // default delimiters

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);

            delimiter = java.util.regex.Pattern.quote(delimiter);
        }

        String[] tokens = numbers.split(delimiter + "|,|\n");
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }    
}
