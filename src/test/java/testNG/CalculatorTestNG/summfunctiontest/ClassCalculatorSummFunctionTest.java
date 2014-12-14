package testNG.CalculatorTestNG.summfunctiontest;

import classes.Calculator;
import dataprovideclasses.DataFromFileToCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClassCalculatorSummFunctionTest {
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileToCalculator.readFromFile("./src/main/resources/dataForTestClassCalcFunctSumm.yaml");
    }

    @DataProvider(name = "test2")
    public static Object[][] classCalcFunctSumm() {
        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test2")
    public void TestForClassCalcFunctSumm(Double firstValue, Double secondValue, Double expectedResult) {
        Assert.assertEquals(calculator.summ(firstValue, secondValue), expectedResult);
    }
}
