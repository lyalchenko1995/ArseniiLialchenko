package com.epam.tc.hw6;

import com.epam.tc.hw4.steps.ActionSteps;
import com.epam.tc.hw4.steps.AssertSteps;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTestHW6 {

    public static WebDriver webDriver;
    protected ActionSteps actionSteps;
    protected AssertSteps assertSteps;
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String USER_LOGIN = "Roman";
    public static final String USER_PASSWORD = "Jdi1234";
    public static final String USER_NAME = "ROMAN IOVLEV";

    @BeforeClass
    @Parameters({"isLocal", "hub", "browser"})
    public void prepareToTest(ITestContext testContext, @Optional("false") final boolean isLocal, final String hub, final String browser) {
        webDriver = DriverFabric.getWebDriver(isLocal, hub, browser);
        testContext.setAttribute("driver", webDriver);
        webDriver.manage().window().maximize();
        webDriver.get(URL);
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
