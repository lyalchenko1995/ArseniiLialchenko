package com.epam.tc.hw3.pages.components;

import static com.epam.tc.hw4.BaseTestHW4.webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ColorsDropDownComponent {

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']")
    private WebElement colorsDropDown;

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']//option[text() = 'Yellow']")
    private WebElement yellowColor;

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
