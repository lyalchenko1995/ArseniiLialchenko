package com.epam.tc.hw3.pages.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogComponent {

    @FindBy(xpath = "ul[class='panel-body-list logs'] > li")
    private List<WebElement> logs;

    @FindBy(xpath = "//*[contains(text(),'Water: condition changed to true')]")
    private WebElement waterLog;

    @FindBy(xpath = "//*[contains(text(),'Wind: condition changed to true')]")
    private WebElement windLog;

    @FindBy(xpath = "//*[contains(text(),'metal: value changed to  Selen')]")
    private WebElement metalLog;

    @FindBy(xpath = "//*[contains(text(),'Colors: value changed to Yellow')]")
    private WebElement colorsLog;

    public List<WebElement> getLogs() {
        return logs;
    }

    public WebElement getWaterLog() {
        return waterLog;
    }

    public WebElement getWindLog() {
        return windLog;
    }

    public WebElement getMetalLog() {
        return metalLog;
    }

    public WebElement getColorsLog() {
        return colorsLog;
    }
}
