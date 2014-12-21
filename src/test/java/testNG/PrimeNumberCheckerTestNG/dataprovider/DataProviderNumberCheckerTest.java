package testNG.PrimeNumberCheckerTestNG.dataprovider;

import classes.PrimeNumberChecker;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.dataprovideclasses.DataFromFileForPrimeNumberChecker;

import java.io.IOException;


public class DataProviderNumberCheckerTest {
    private PrimeNumberChecker primeNumberChecker;
    private static Object[][] testingData;
    private static final Logger LOG = Logger.getLogger(DataProviderNumberCheckerTest.class);

    @BeforeTest
    public void initialize() throws IOException {
        primeNumberChecker = new PrimeNumberChecker();
        testingData = DataFromFileForPrimeNumberChecker.readFromFile("./src/main/resources/datafortestPrimeNumberChecker.yaml");
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("Initialize finished");
    }

    @DataProvider(name = "test1")
    public static Object[][] primeNumber() {
        LOG.info("Dataprovider starts");

        return testingData;
    }

    @Test(dataProvider = "test1")
    public void dataProviderTest(Integer valueToTest, Boolean expectedResult) {
        try {
            LOG.info("Test Starts");
            LOG.debug("Value to test: " + valueToTest + " Expected result: " + expectedResult);
            Assert.assertEquals(primeNumberChecker.validate(valueToTest), expectedResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
