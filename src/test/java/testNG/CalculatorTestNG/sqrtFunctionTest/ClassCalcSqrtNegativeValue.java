package testNG.CalculatorTestNG.sqrtFunctionTest;

import classes.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassCalcSqrtNegativeValue {
    private Calculator calculator;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
    }

    @Test
    public void test() {
        Assert.assertTrue(Double.isNaN(calculator.sqrt(-5)));
    }
}
