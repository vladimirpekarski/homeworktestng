package testNG.CalculatorTestNG.sqrtFunctionTest;

import classes.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.dataprovideclasses.DataFromFileForSqrtFunction;

public class ClassCalculatorSqrtFunctionTest {
    private Calculator calculator;
    private static Object[][] testingDataForFunctSumm;

    @BeforeTest
    public void initialize() {
        calculator = new Calculator();
        testingDataForFunctSumm  = DataFromFileForSqrtFunction.readFromFile("./src/main/resources/dataForTestClassCalcSqrt.yaml");
    }

    @DataProvider(name = "test4")
    public static Object[][] classCalcFunctSqrt() {
        return testingDataForFunctSumm;
    }

    @Test(dataProvider = "test4")
    public void TestForClassSqrtFunctSqrt(Double firstValue, Double expectedResult) {
        Assert.assertEquals(calculator.sqrt(firstValue), expectedResult);
    }
}
