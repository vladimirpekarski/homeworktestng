package testNG.CalculatorTestNG.divideFunctuontest;

import classes.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassCalculatorDivideByZero {
    private Calculator calculator;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZeroTest() {
       calculator.divide(5.0, 0.0);
    }
}
