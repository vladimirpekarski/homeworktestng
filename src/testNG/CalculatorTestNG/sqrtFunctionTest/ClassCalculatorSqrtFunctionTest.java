package testNG.CalculatorTestNG.sqrtFunctionTest;

import classes.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.CalculatorTestNG.dataprovide.DataFromFileToCalculator;

public class ClassCalculatorSqrtFunctionTest {
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileToCalculator.readFromFile("./resources/dataForTestClassCalcFunctDivide.yaml");
    }

    @DataProvider(name = "test4")
    public static Object[][] classCalcFunctSumm() {
        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test4")
    public void TestForClassSqrtFunctDicide(Double firstValue, Double expectedResult) {
        Assert.assertEquals(calculator.sqrt(firstValue), expectedResult);
    }
}
