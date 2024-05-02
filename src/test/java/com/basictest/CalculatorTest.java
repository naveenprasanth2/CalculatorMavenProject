package com.basictest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void integerDivision(){
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4, 2);
        assertEquals(2, result, "This method should return 2 and that should be asserted");
    }
}