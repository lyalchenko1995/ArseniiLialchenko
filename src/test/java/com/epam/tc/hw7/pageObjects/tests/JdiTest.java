package com.epam.tc.hw7.pageObjects.tests;


import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.pageObjects.SiteJdi;
import com.epam.tc.hw7.pageObjects.steps.StepsHW7;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Feature("Metals & Colors page feature")
@Story("Metals & Colors page story")
public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("before is started");
        PageFactory.initSite(SiteJdi.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("after is started");
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
   public void testMetalsColors() {
        StepsHW7.loginJDI();
    }
}
