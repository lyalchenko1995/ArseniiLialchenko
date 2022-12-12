package com.epam.tc.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest extends ArithmeticOperations {

    @DataProvider
    public static Object[][] multCorrectData() {
        return new Object[][] {
                {1.0, 2.0, 2.0},
                {-1.0, 3.0, -3.0}
        };
    }

    @Test(dataProvider = "multCorrectData", groups = "multiplyDivision")
    public void addTest(double a, double b, double res) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, res, 0.0001);
    }
}
