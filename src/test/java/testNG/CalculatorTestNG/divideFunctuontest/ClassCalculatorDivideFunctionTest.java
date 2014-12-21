package testNG.CalculatorTestNG.divideFunctuontest;

import classes.Calculator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.dataprovideclasses.DataFromFileToCalculator;

public class ClassCalculatorDivideFunctionTest {
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;
    private static final Logger LOG = Logger.getLogger(ClassCalculatorDivideByZero.class);

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileToCalculator.readFromFile("./src/main/resources/dataForTestClassCalcFunctDivide.yaml");
        PropertyConfigurator.configure("./src/log4j.properties");
    }

    @DataProvider(name = "test3")
    public static Object[][] classCalcFunctDivide() {

        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test3")
    public void TestForClassCalcFunctDivide(Double firstValue, Double secondValue, Double expectedResult) {
        Assert.assertEquals(calculator.divide(firstValue, secondValue), expectedResult);
    }
}
