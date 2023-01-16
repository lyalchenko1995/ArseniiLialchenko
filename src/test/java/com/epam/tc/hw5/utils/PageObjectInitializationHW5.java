package com.epam.tc.hw5.utils;

import com.epam.tc.TestData;
import com.epam.tc.hw5.pages.DifferentElementsPageHW5;
import com.epam.tc.hw5.pages.HomePageHW5;
import com.epam.tc.hw5.pages.LoginPageHW5;
import org.openqa.selenium.WebDriver;

public class PageObjectInitializationHW5 {
    protected WebDriver webDriver;

    protected DifferentElementsPageHW5 differentElementsPage;
    protected HomePageHW5 homePage;
    protected LoginPageHW5 loginPage;

    public PageObjectInitializationHW5() {
        webDriver = new DriverManagerUtils().setupDriver();

        differentElementsPage = new DifferentElementsPageHW5(webDriver);
        homePage = new HomePageHW5(webDriver);
        loginPage = new LoginPageHW5(webDriver);
    }
}
