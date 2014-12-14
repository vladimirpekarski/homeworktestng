package testNG.dataprovider;

import classes.PrimeNumberChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class DataProviderNumberCheckerTest {
    private PrimeNumberChecker primeNumberChecker;
    private static Object[][] testingData;

    @BeforeTest
    public void initialize() throws IOException {
        primeNumberChecker = new PrimeNumberChecker();
        testingData = DataFromFile.readFromFile("./src/testNG/dataprovider/datafortest.yaml");
    }

    @DataProvider(name = "test1")
    public static Object[][] primeNumber() {
        return testingData;
    }

    @Test(dataProvider = "test1")
    public void dataProviderTest(Integer valueToTest, Boolean expectedResult) {
        Assert.assertEquals(primeNumberChecker.validate(valueToTest), expectedResult);
    }
}
