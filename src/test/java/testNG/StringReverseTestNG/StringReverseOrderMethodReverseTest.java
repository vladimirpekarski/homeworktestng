package testNG.StringReverseTestNG;

import classes.StringReverseOrder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StringReverseOrderMethodReverseTest {
    private StringReverseOrder stringReverseOrder;
    private static final Logger LOG = Logger.getLogger(StringReverseOrderMethodReverseTest.class);

    @BeforeTest
    public void init(){
        stringReverseOrder = new StringReverseOrder();
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("Initialize finished");
    }

    @Test
    public void methodReverseFirstTest(){
        try {
            LOG.info("Test Starts");
            LOG.debug("Value to test: testvalue");
            Assert.assertEquals(stringReverseOrder.reverseValue("testvalue"), "eulavtset");
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("methodReverseFirstTest test fails" + e);
            Assert.fail("methodReverseFirstTest test fails");
        }
    }

    @Test
    public void methodReverseSecondTest(){
        try {
            LOG.info("Test Starts");
            LOG.debug("Value to test:  Test reverse ! @ # $ ");
            Assert.assertEquals(stringReverseOrder.reverseValue(" Test reverse ! @ # $ "), " $ # @ ! esrever tseT ");
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("methodReverseSecondTest test fails" + e);
            Assert.fail("methodReverseSecondTest test fails");
        }
    }

    @Test
    public void methodLengthTest(){
        try {
            LOG.info("Test Starts");
            LOG.debug("Value to test: 11");
            stringReverseOrder.reverseValue("test length");
            Assert.assertEquals(stringReverseOrder.length(), 11);
            LOG.info("Test Ends");
        } catch (AssertionError e) {
            LOG.error("methodLengthTest test fails" + e);
            Assert.fail("methodLengthTest test fails");
        }
    }

    @Test
    public void methodCharAtTest(){
        stringReverseOrder.reverseValue("test char At");
        Assert.assertEquals(stringReverseOrder.charAt(10), 'e');
    }

    @Test
    public void methodSubSequenceTest(){
        stringReverseOrder.reverseValue("test Sub Sequence Test");
        Assert.assertEquals(stringReverseOrder.subSequence(0, 4), "tseT");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void methodReverseNullTest(){
        stringReverseOrder.reverseValue(null);
    }
}
