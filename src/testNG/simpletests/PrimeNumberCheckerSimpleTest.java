package testNG.simpletests;

import objects.PrimeNumberChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PrimeNumberCheckerSimpleTest {
    private PrimeNumberChecker primeNumberChecker;

    @BeforeTest
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    @Test
    public void testPrimeNumberCheckerTrue() {
        Assert.assertTrue(primeNumberChecker.validate(2));
    }

    @Test
    public void testPrimeNumberCheckerFailse() {
        Assert.assertFalse(primeNumberChecker.validate(6));
    }


    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPointerException() {
        primeNumberChecker.validate(null);
    }

    @Test
    public void testPrimeNumberCheckerNegativeValue() {
        Assert.assertFalse(primeNumberChecker.validate(-5));
    }
}
