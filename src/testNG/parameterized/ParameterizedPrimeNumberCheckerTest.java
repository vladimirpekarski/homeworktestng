package testNG.parameterized;

import classes.PrimeNumberChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedPrimeNumberCheckerTest {
    private PrimeNumberChecker primeNumberChecker;

    @BeforeTest
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    @Test
    @Parameters({"valueToTest", "expectedResult"})
    public void perameterTest(int valueToTest, Boolean expectedResult) {
        Assert.assertEquals(primeNumberChecker.validate(valueToTest), expectedResult);
    }
}
