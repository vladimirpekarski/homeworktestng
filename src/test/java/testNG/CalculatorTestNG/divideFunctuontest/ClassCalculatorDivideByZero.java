package testNG.CalculatorTestNG.divideFunctuontest;

import classes.Calculator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ClassCalculatorDivideByZero {
    private static final Logger LOG = Logger.getLogger(ClassCalculatorDivideByZero.class);
    private Calculator calculator;


    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        PropertyConfigurator.configure("./src/log4j.properties");
    }


    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZeroTest() {
        LOG.info("Start Test");
        calculator.divide(5.0, 0.0);
        LOG.info("Test Ends");
    }
}
