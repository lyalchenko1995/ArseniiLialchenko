package com.epam.tc.hw3.pages.pageComponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ColorsDropDownComponent {

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']")
    private WebElement colorsDropDown;

    public void clickOnDropDownColor() {
        colorsDropDown.click();
    }
}
