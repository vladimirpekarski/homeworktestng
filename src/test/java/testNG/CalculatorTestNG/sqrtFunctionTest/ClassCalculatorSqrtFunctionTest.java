package testNG.CalculatorTestNG.sqrtFunctionTest;

import classes.Calculator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.dataprovideclasses.DataFromFileForSqrtFunction;

public class ClassCalculatorSqrtFunctionTest {
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;
    private static final Logger LOG = Logger.getLogger(ClassCalculatorSqrtFunctionTest.class);

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileForSqrtFunction.readFromFile("./src/main/resources/dataForTestClassCalcSqrt.yaml");
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("Initialize finished");
    }

    @DataProvider(name = "test4")
    public static Object[][] classCalcFunctSqrt() {
        LOG.info("Dataprovider starts");

        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test4")
    public void TestForClassSqrtFunctSqrt(Double firstValue, Double expectedResult) {
        LOG.info("Test Starts");
        LOG.debug("First value: " + firstValue + " Expected result: " + expectedResult);
        Assert.assertEquals(calculator.sqrt(firstValue), expectedResult);
        LOG.info("Test Ends");
    }
}
