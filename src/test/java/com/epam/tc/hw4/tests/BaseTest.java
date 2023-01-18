package com.epam.tc.hw4.tests;

import com.epam.tc.hw3.utils.DriverManager;
import com.epam.tc.hw4.steps.ActionSteps;
import com.epam.tc.hw4.steps.AssertSteps;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver webDriver;
    protected ActionSteps actionSteps;
    protected AssertSteps assertSteps;
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String USER_LOGIN = "Roman";
    public static final String USER_PASSWORD = "Jdi1234";
    public static final String USER_NAME = "ROMAN IOVLEV";

    @BeforeClass
    public void preparetoTest(ITestContext testContext) {
        webDriver = new DriverManager().setupDriver(URL);
        testContext.setAttribute("driver", webDriver);
        actionSteps = new ActionSteps(webDriver);
        assertSteps = new AssertSteps(webDriver);
    }

    @AfterClass
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
