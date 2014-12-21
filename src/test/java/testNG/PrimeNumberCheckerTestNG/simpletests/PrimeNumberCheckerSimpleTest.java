package testNG.PrimeNumberCheckerTestNG.simpletests;

import classes.PrimeNumberChecker;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PrimeNumberCheckerSimpleTest {
    private PrimeNumberChecker primeNumberChecker;
    private static final Logger LOG = Logger.getLogger(PrimeNumberCheckerSimpleTest.class);

    @BeforeTest
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("Initialize finished");
    }

    @Test
    public void testPrimeNumberCheckerTrue() {
        try {
            LOG.info("Test Starts");
            LOG.debug("Value to test: 2");
            Assert.assertTrue(primeNumberChecker.validate(2));
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("testPrimeNumberCheckerTrue test fails" + e);
            Assert.fail("testPrimeNumberCheckerTrue test fails");
        }
    }

    @Test
    public void testPrimeNumberCheckerFailse() {
        try {
            LOG.info("Test Starts");
            LOG.debug("Value to test: 6");
            Assert.assertFalse(primeNumberChecker.validate(6));
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("testPrimeNumberCheckerFailse test fails" + e);
            Assert.fail("testPrimeNumberCheckerFailse test fails");
        }
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPointerException() {
        try {
            LOG.info("Test Starts");
            LOG.debug("Value to test: null");
            primeNumberChecker.validate(null);
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("testNullPointerException test fails" + e);
            Assert.fail("testNullPointerException test fails");
        }
    }

    @Test
    public void testPrimeNumberCheckerNegativeValue() {
        Assert.assertFalse(primeNumberChecker.validate(-5));
    }
}
