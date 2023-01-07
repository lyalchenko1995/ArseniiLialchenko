package com.epam.tc.hw4.utils;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectInitialization {
    protected DifferentElementsPage differentElementsPage;
    protected HomePage homePage;
    protected LoginPage loginPage;

    protected PageObjectInitialization(WebDriver webDriver) {
    differentElementsPage = new DifferentElementsPage(webDriver);
    homePage = new HomePage(webDriver);
    loginPage = new LoginPage(webDriver);
    }
}
