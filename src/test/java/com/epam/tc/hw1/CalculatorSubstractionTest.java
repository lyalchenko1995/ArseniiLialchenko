package com.epam.tc.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubstractionTest extends ArithmeticOperations {

    @DataProvider(name = "subsCorrectData")
    public static Object[][] subsCorrectData() {
        return new Object[][] {
                {3.0, 2.0, 1.0},
                {-5.0, 3.0, -8.0}
        };
    }

    @Test(dataProvider = "subsCorrectData", groups = {"additionalSubstraction"})
    public void addTest(double a, double b, double res) {
        double result = calculator.sub(a, b);
        Assert.assertEquals(result, res, 0.0001);
    }
}
