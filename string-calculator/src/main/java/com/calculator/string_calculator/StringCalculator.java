package com.calculator.string_calculator;

public class StringCalculator {
    private int callCount = 0;

    public int add(String numbers){
        callCount++;

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
        StringBuilder negatives = new StringBuilder();

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            int num = Integer.parseInt(token);

            if (num < 0) {
                if (negatives.length() > 0) negatives.append(",");
                negatives.append(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (negatives.length() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negatives);
        }

        return sum;
    }

    public int GetCalledCount() {
        return callCount;
    }
}
