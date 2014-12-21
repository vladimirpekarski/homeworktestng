package testNG.CalculatorTestNG.sqrtFunctionTest;

import classes.Calculator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassCalcSqrtNegativeValueTest {
    private static final Logger LOG = Logger.getLogger(ClassCalcSqrtNegativeValueTest.class);
    private Calculator calculator;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("initialize finished");
    }

    @Test
    public void negativeValueInSqrt() {
        try {
            LOG.info("Test Starts");
            Assert.assertFalse(Double.isNaN(calculator.sqrt(-5)));
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("ClassCalcSqrtNegativeValueTest test fails " + e);
            Assert.fail("ClassCalcSqrtNegativeValueTest test fails");
        }
    }
}
