package testNG.CalculatorTestNG.multiplyFunctionTest;

import classes.Calculator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.dataprovideclasses.DataFromFileToCalculator;

public class ClassCalculatorMultiplyFunctionTest {
    private static final Logger LOG = Logger.getLogger(ClassCalculatorMultiplyFunctionTest.class);
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileToCalculator.readFromFile("./src/main/resources/dataForTestClassCalcFunctMultiply.yaml");
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("Initialize finished");
    }

    @DataProvider(name = "test4")
    public static Object[][] classCalcFunctMultiply() {
        LOG.info("Dataprovider starts");

        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test4")
    public void TestForClassCalcFunctMultiply(Double firstValue, Double secondValue, Double expectedResult) {
        LOG.info("Test Starts");
        LOG.debug("First value: " + firstValue + " Second value: " + secondValue + " Expected result: " + expectedResult);
        Assert.assertEquals(calculator.multiply(firstValue, secondValue), expectedResult);
        LOG.info("Test Ends");
    }
}
