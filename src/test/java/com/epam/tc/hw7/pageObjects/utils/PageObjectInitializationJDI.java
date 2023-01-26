package com.epam.tc.hw7.pageObjects.utils;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.pageObjects.SiteJdi;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PageObjectInitializationJDI {
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        PageFactory.initSite(SiteJdi.class);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
