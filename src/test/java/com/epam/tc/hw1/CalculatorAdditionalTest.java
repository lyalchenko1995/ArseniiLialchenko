package com.epam.tc.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorAdditionalTest extends ArithmeticOperations {

    @DataProvider
    public static Object[][] addCorrectData() {
        return new Object[][] {
            {1.0, 2.0, 3.0},
            {-1.0, 0.0, -1.0}
        };
    }

    @Test(dataProvider = "addCorrectData", groups = "additionalSubstraction")
    public void addTest(double a, double b, double res) {
        double result = calculator.sum(a, b);
        Assert.assertEquals(result, res, 0.0001);
    }
}
