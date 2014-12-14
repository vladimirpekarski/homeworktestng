package testNG.CalculatorTestNG.multiplyFunctionTest;

import classes.Calculator;
import dataprovideclasses.DataFromFileToCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClassCalculatorMultiplyFunctionTest {
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileToCalculator.readFromFile("./src/main/resources/dataForTestClassCalcFunctMultiply.yaml");
    }

    @DataProvider(name = "test4")
    public static Object[][] classCalcFunctMultiply() {
        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test4")
    public void TestForClassCalcFunctMultiply(Double firstValue, Double secondValue, Double expectedResult) {
        Assert.assertEquals(calculator.multiply(firstValue, secondValue), expectedResult);
    }
}
