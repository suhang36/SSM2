package Service.impl;

import Service.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {

    @Override
    public double add(int i, int j) {
        return i+j;
    }

    @Override
    public double sub(int i, int j) {
        return i-j;
    }

    @Override
    public double div(int i, int j) {
        return i/j;
    }

    @Override
    public double mul(int i, int j) {
        return i*j;
    }
}
