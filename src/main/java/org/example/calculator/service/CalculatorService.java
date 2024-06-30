package org.example.calculator.service;

import org.example.calculator.dto.ResultRecord;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public ResultRecord add(double a, double b) {
        return new ResultRecord(a + b);
    }

    public ResultRecord sub(double a, double b) {
        return new ResultRecord(a - b);
    }

    public ResultRecord mul(double a, double b) {
        return new ResultRecord(a * b);
    }

    public ResultRecord div(double a, double b) {
        return new ResultRecord(a / b);
    }
}
