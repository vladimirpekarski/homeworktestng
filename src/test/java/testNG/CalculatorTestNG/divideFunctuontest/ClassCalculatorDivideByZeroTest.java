package testNG.CalculatorTestNG.divideFunctuontest;

import classes.Calculator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ClassCalculatorDivideByZeroTest {
    private static final Logger LOG = Logger.getLogger(ClassCalculatorDivideByZeroTest.class);
    private Calculator calculator;


    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("Initialize finished");
    }


    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZeroTest() {
        try {
            LOG.info("Test Starts");
            calculator.divide(5.0, 0.0);
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("ClassCalculatorDivideByZeroTest test fails " + e);
            Assert.fail("ClassCalculatorDivideByZeroTest test fails");
        }
    }
}
