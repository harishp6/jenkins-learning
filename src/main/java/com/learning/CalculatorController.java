package com.learning;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Map<String, Integer> add(
            @RequestParam int a,
            @RequestParam int b) {
        return Map.of("result", a + b);
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divide(
            @RequestParam int a,
            @RequestParam int b) {
        if (b == 0) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "b must not be zero"));
        }
        return ResponseEntity.ok(Map.of("result", a / b));
    }
}