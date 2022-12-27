package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.pages.pageComponents.ColorsDropDownComponent;
import com.epam.tc.hw3.pages.pageComponents.LogComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage {

    private ColorsDropDownComponent colorsDropDownComponent;

    private LogComponent logComponent;

    @FindBy(xpath = "//label[@class='label-checkbox'][1]/*")
    private WebElement waterCheckBox;

    @FindBy(xpath = "//label[@class='label-checkbox'][3]/*")
    private WebElement windCheckBox;

    @FindBy(xpath = "//label[@class='label-radio'][4]/*")
    private WebElement radioSelen;

    public ColorsDropDownComponent getColorsDropDownComponent() {
        return colorsDropDownComponent;
    }

    public LogComponent getLogComponent() {
        return logComponent;
    }

    public WebElement getWaterCheckBox() {
        return waterCheckBox;
    }

    public WebElement getWindCheckBox() {
        return windCheckBox;
    }

    public WebElement getRadioSelen() {
        return radioSelen;
    }
}
