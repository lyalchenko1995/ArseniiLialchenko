package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.ColorsDropDownComponentHW5;
import com.epam.tc.hw5.pages.components.LogComponentHW5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPageHW5 extends MainPageHW5 {

    private ColorsDropDownComponentHW5 colorsDropDownComponent;

    private LogComponentHW5 logComponent;

    public DifferentElementsPageHW5(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        colorsDropDownComponent = new ColorsDropDownComponentHW5(webDriver);
        logComponent = new LogComponentHW5();
        PageFactory.initElements(webDriver, colorsDropDownComponent);
        PageFactory.initElements(webDriver, logComponent);
    }

    public ColorsDropDownComponentHW5 getColorsDropDownComponent() {
        return colorsDropDownComponent;
    }

    public LogComponentHW5 getLogComponent() {
        return logComponent;
    }


    public WebElement findElement(String checkBoxName) {
        String xpath = String.format("//label[text()[contains(.,' %s')]]/input", checkBoxName);
        WebElement checkBoxElement = webDriver.findElement(By.xpath(xpath));
        return checkBoxElement;
    }
}
