package org.example.calculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.example.calculator.dto.ResultRecord;
import org.example.calculator.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/calculator")
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Operation(summary = "Die Summe von zwei Parametern berechnen")
    @PostMapping("/add")
    public ResultRecord add(@RequestParam double a, @RequestParam double b) {
        log.debug("/add get parameters: a={}, b={}", a, b);
        return calculatorService.add(a, b);
    }

    @Operation(summary = "Die Differenz von zwei Parametern berechnen")
    @PostMapping("/sub")
    public ResultRecord sub(@RequestParam double a, @RequestParam double b) {
        log.debug("/sub get parameters: a={}, b={}", a, b);
        return calculatorService.sub(a, b);
    }

    @Operation(summary = "Die Multiplikation von zwei Parametern berechnen")
    @PostMapping("/mul")
    public ResultRecord mul(@RequestParam double a, @RequestParam double b) {
        log.debug("/mul get parameters: a={}, b={}", a, b);
        return calculatorService.mul(a, b);
    }

    @Operation(summary = "Die Division von zwei Parametern berechnen")
    @PostMapping("/div")
    public ResultRecord div(@RequestParam double a, @RequestParam @Parameter(description = "darf nicht 0 sein") double b) {
        log.debug("/div get parameters: a={}, b={}", a, b);
        if (b == 0) {
            log.warn("Division by 0");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Division by 0");
        }
        return calculatorService.div(a, b);
    }
}
