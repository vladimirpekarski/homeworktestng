package testNG.CalculatorTestNG.summfunctiontest;

import classes.Calculator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.dataprovideclasses.DataFromFileToCalculator;

public class ClassCalculatorSummFunctionTest {
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;
    private static final Logger LOG = Logger.getLogger(ClassCalculatorSummFunctionTest.class);

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileToCalculator.readFromFile("./src/main/resources/dataForTestClassCalcFunctSumm.yaml");
        PropertyConfigurator.configure("./src/log4j.properties");
        LOG.info("Initialize finished");
    }

    @DataProvider(name = "test2")
    public static Object[][] classCalcFunctSumm() {
        LOG.info("Dataprovider starts");

        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test2")
    public void TestForClassCalcFunctSumm(Double firstValue, Double secondValue, Double expectedResult) {
        try {
            LOG.info("Test Starts");
            LOG.debug("First value: " + firstValue + "Second value: " + secondValue + " Expected result: " + expectedResult);
            Assert.assertEquals(calculator.summ(firstValue, secondValue), expectedResult);
        } catch (AssertionError e) {
            LOG.error("ClassCalculatorSummFunctionTest test fails " + e);
            Assert.fail("ClassCalculatorSummFunctionTest test fails");
        }
    }
}
