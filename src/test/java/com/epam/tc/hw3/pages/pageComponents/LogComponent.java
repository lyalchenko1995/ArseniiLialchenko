package com.epam.tc.hw3.pages.pageComponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogComponent {

    @FindBy(xpath = "ul[class='panel-body-list logs'] > li")
    private WebElement logs;

    @FindBy(xpath = "//*[contains(text(),'Water: condition changed to true')]")
    private WebElement waterLog;

    @FindBy(xpath = "//*[contains(text(),'Wind: condition changed to true')]")
    private WebElement windLog;

    @FindBy(xpath = "//*[contains(text(),'metal: value changed to  Selen')]")
    private WebElement metalLog;

    @FindBy(xpath = "//*[contains(text(),'Colors: value changed to Yellow')]")
    private WebElement colorsLog;
}
