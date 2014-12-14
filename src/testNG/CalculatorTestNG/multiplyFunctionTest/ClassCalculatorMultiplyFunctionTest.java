package testNG.CalculatorTestNG.multiplyFunctionTest;

import classes.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.CalculatorTestNG.dataprovide.DataFromFileToCalculator;

public class ClassCalculatorMultiplyFunctionTest {
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileToCalculator.readFromFile("./resources/dataForTestClassCalcFunctMultiply.yaml");
    }

    @DataProvider(name = "test4")
    public static Object[][] classCalcFunctSumm() {
        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test4")
    public void TestForClassCalcFunctDicide(Double firstValue, Double secondValue, Double expectedResult) {
        Assert.assertEquals(calculator.multiply(firstValue, secondValue), expectedResult);
    }
}
