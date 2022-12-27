package com.epam.tc.hw3;

import com.epam.tc.hw3.driverUtils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void preparetoTest() {
        webDriver = new DriverManager().setupDriver();
    }

    @AfterClass
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
