package org.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.calculator.Calculator;
// import org.junit.Text;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test 
    public void saveAndLoad() {
        Calculator calc = new Calculator();
        calc.saveValue(10);
        double actual = calc.calculatorMode("2 + %0");
        double expected = 12.0;
        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        Calculator calc = new Calculator();
        double actual = calc.calculatorMode("5 + 100");
        double expected = 105.0;
        assertEquals(expected, actual);
    }

    @Test 
    public void product() {
        Calculator calc = new Calculator();
        double actual = calc.calculatorMode("4 * 5");
        double expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void saveAndPower() {
        Calculator calc = new Calculator();
        calc.saveValue(3);
        double actual = calc.calculatorMode("%0 ^ %0");
        double expected = 27.0;
        assertEquals(expected, actual);
    }
}
