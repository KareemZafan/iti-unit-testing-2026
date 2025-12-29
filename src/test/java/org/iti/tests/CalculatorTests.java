package org.iti.tests;

import org.iti.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTests {

    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test cases this method will be run");
        calculator = new Calculator();
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1, 12, 13),
                Arguments.of(-12, 1, -11),
                Arguments.of(-12, -1, -13),
                Arguments.of(12, -1, 11),
                Arguments.of(12, 0, 12),
                Arguments.of(0, 12, 12),
                Arguments.of(0, -12, -12),
                Arguments.of(0, 0, 0)

        );

    }


    @DisplayName("Test- Add functionality")
    @ParameterizedTest
    @MethodSource(value = "provideTestData")
    void testAdd(double a, double b, double expected) {
        // Arrange
        // Action, Assertio
        assertEquals(expected, calculator.add(a, b));
    }

    @DisplayName("Feature-123 Test subtraction functionality")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testSubtract(String input1, String input2, String result) {

        // Arrange

        // Action, Assertio
        assertEquals(Double.parseDouble(result), calculator.sub(Double.parseDouble(input1), Double.parseDouble(input2)));

        /*assertEquals(11, calculator.sub(12, 1));
        assertEquals(-13, calculator.sub(-12, 1));
        assertEquals(-11, calculator.sub(-12, -1));
        assertEquals(13, calculator.sub(12, -1));
        assertEquals(12, calculator.sub(12, 0));
        assertEquals(-12, calculator.sub(0, 12));
        assertEquals(12, calculator.sub(0, -12));
        assertEquals(0, calculator.sub(0, 0));*/

    }

    @Test
    @Tag("FEB_RELEASE")
    void testMultiplication() {

        // Arrange

        // Action, Assertio

        assertEquals(12, calculator.mul(12, 1));
        assertEquals(-12, calculator.mul(-12, 1));
        assertEquals(12, calculator.mul(-12, -1));
        assertEquals(-12, calculator.mul(12, -1));
        assertEquals(0, calculator.mul(12, 0));
        assertEquals(0, calculator.mul(0, 12));
        assertEquals(0, calculator.mul(0, -12));
        assertEquals(0, calculator.mul(0, 0));

    }

    @Test
    void testDivision() {

        // Arrange

        // Action, Assertio

        assertEquals(12, calculator.div(12, 1));
        assertEquals(-12, calculator.div(-12, 1));
        assertEquals(12, calculator.div(-12, -1));
        assertEquals(-12, calculator.div(12, -1));
        assertEquals(0, calculator.div(0, 12));
        assertEquals(0, calculator.div(0, -12));

        Exception ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.div(12, 0));
        assertEquals("Division by zero", ex.getMessage());
    }

    @Test
    @Tag("FEB_RELEASE")
    void testPower() {

        // Arrange

        // Action, Assertio

        assertEquals(12, calculator.pow(12, 1));
        assertEquals(-12, calculator.pow(-12, 1));
        assertEquals(1, calculator.pow(-12, 0));
        assertEquals(0.08333333333333333, calculator.pow(12, -1));
        assertEquals(0, calculator.pow(0, 12));
    }

    @Test
    void testSquareRoot() {

        // Arrange

        // Action, Assertio

        assertEquals(10, calculator.getSquareRoot(100));
        assertEquals(0, calculator.getSquareRoot(0));

        Exception ex = assertThrowsExactly(IllegalArgumentException.class, () -> calculator.getSquareRoot(-1));
        assertEquals("Square root must be positive", ex.getMessage());

    }

    @Test
    void testModulus() {

        // Arrange

        // Action, Assertio

        assertEquals(0, calculator.mod(100, 4));
        assertEquals(2, calculator.mod(50, 3));
        assertEquals(2, calculator.mod(12, 5));

    }

    @Test
    void testAbsolute() {

        // Arrange

        // Action, Assertio

        assertEquals(100, calculator.abs(100));
        assertEquals(100, calculator.abs(-100));
        assertEquals(0, calculator.abs(0));

    }


}
