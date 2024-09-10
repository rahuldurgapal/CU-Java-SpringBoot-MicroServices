package com.example.AopApplication.controller;

import com.example.AopApplication.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping("/api/calculation")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return calculationService.add(a, b);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return calculationService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return calculationService.multiply(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam int a, @RequestParam int b) {
        return calculationService.divide(a, b);
    }
}