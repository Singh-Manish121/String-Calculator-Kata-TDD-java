package com.calculator.string_calculator.models;

public class models {

    public static class ResultResponse {
        public int result;
        public int callCount;

        public ResultResponse(int result, int callCount) {
            this.result = result;
            this.callCount = callCount;
        }
    }

    public static class ErrorResponse {
        public String error;

        public ErrorResponse(String error) {
            this.error = error;
        }
    }
    
}
