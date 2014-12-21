package testNG.PrimeNumberCheckerTestNG.parameterized;

import classes.PrimeNumberChecker;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedPrimeNumberCheckerTest {
    private PrimeNumberChecker primeNumberChecker;
    private static final Logger LOG = Logger.getLogger(ParameterizedPrimeNumberCheckerTest.class);

    @BeforeTest
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("Initialize finished");
    }

    @Test
    @Parameters({"valueToTest", "expectedResult"})
    public void perameterTest(int valueToTest, Boolean expectedResult) {
        try {
            LOG.info("Test Starts");
            LOG.debug("Value to test: " + valueToTest + " Expected result: " + expectedResult);
            Assert.assertEquals(primeNumberChecker.validate(valueToTest), expectedResult);
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("ParameterizedPrimeNumberCheckerTest test fails " + e);
            Assert.fail("ParameterizedPrimeNumberCheckerTest test fails");
        }
    }
}
