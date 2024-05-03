package com.basictest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test math operations in calculator class")
class CalculatorTest {
    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method");
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("Executing @AfterAll method");
    }

    @BeforeEach
    void beforeEachMethods() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method");
    }

    @AfterEach
    void afterEachMethods() {
        System.out.println("Executing @AfterEach method");
    }

    //test<System under test>_<Condition or State change>_<Expected result>
    //the above is same as Given, When and Then only
    @DisplayName("Test 4/2 = 2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        int result = calculator.integerDivision(4, 2);
        assertEquals(2, result, "This method should return 2 and that should be asserted");
    }

    @DisplayName("Subtract 2-2 = 0")
    @Test
    void testIntegerSubtraction_TwoMinusTwo_ShouldReturnZero() {
        int result = calculator.integerSubtraction(2, 2);
        assertEquals(0, result, "It should give you the subtracted value");
    }

    @DisplayName("Divide by zero")
    @Test
    void testIntegerDivision_WhenDividedByZero_ShouldThrowAnException() {
        int dividend = 5;
        int divisor = 0;
        assertThrows(ArithmeticException.class, () -> calculator.integerDivision(dividend, divisor));
    }

//    @MethodSource("integerSubtractionInputParameters")
//    @CsvSource({"1, 2, -1", "2, 2, 0"})
    @CsvFileSource(resources = "/integerSubtraction.csv") 
    @ParameterizedTest
    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult]")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        assertEquals(expectedResult, calculator.integerSubtraction(minuend, subtrahend));
    }

    private static Stream<Arguments> integerSubtractionInputParameters() {
        return Stream.of(
                Arguments.of(3, 4, -1), Arguments.of(1, 2, -1), Arguments.of(5, 4, 1)
        );
    }
}