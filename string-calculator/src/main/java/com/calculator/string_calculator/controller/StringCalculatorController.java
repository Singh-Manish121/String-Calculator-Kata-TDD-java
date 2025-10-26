package com.calculator.string_calculator.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.calculator.string_calculator.StringCalculator;
import com.calculator.string_calculator.models.models.*;


@RestController
@RequestMapping("/api")
public class StringCalculatorController {

    private final StringCalculator calculator = new StringCalculator();

    @PostMapping("/add")
    public ResponseEntity<?> addNumbers(@RequestBody String input) {
        try {
            int result = calculator.add(input);
            int callCount = calculator.GetCalledCount();

            return ResponseEntity.ok(new ResultResponse(result, callCount));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }
}

