package com.epam.tc.hw3.driverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }
    public WebDriver setupDriver() {
        setupChromeDriver();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }
}
