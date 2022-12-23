package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class InitializeWebSite {

    protected WebDriver webDriver;
    static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public void runWebDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(URL);
    }

    @AfterClass
    public void closeWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public WebElement findElementBySelector(By by) {
        return  webDriver.findElement(by);
    }

    public List<WebElement> findElementsBySelector(By by) {
        return  webDriver.findElements(by);
    }
}