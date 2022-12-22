package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class ArithmeticOperations {

    protected Calculator calculator;

    @BeforeMethod(groups = {"multiplyDivision", "additionalSubstraction"})
    public void initializeCalculator() {
        calculator = new Calculator();
    }

    @AfterMethod(groups = {"multiplyDivision", "additionalSubstraction"})
    public void clearCalculator() {
        calculator = null;
    }
}
