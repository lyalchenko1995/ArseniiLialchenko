package com.epam.tc.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivisionTest extends ArithmeticOperations {

    @DataProvider
    public static Object[][] divCorrectData() {
        return new Object[][] {
                {6.0, 2.0, 3.0},
                {0.0, 1.0, 0.0}
        };
    }

    @Test(dataProvider = "divCorrectData", groups = "multiplyDivision")
    public void addTest(double a, double b, double res) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, res, 0.0001);
    }
}
