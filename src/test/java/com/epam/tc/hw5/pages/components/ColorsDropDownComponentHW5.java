package com.epam.tc.hw5.pages.components;

import com.epam.tc.hw5.pages.MainPageHW5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ColorsDropDownComponentHW5 extends MainPageHW5 {

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']")
    private WebElement colorsDropDown;

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']//option[text() = 'Yellow']")
    private WebElement yellowColor;

    public ColorsDropDownComponentHW5(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnDropDownColor() {
        colorsDropDown.click();
    }

    public WebElement getYellowColor() {
        return yellowColor;
    }

    public WebElement findColor(String colorName) {
        String xpath =
                String.format(".//*[@class='colors']//*[@class='uui-form-element']//option[text() = '%s']", colorName);
        WebElement checkBoxElement = webDriver.findElement(By.xpath(xpath));
        return checkBoxElement;
    }
}
