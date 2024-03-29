package com.epam.tc.hw5.pages.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponentHW5 {

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> navigationBarHeaderElements;

    @FindBy(partialLinkText = "HOME")
    private WebElement homeHeaderElement;

    @FindBy(partialLinkText = "CONTACT FORM")
    private WebElement contactFormHeaderElement;

    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderElement;

    @FindBy(partialLinkText = "METALS & COLORS")
    private WebElement metalColorsHeaderElement;

    public List<WebElement> getNavigationBarHeaderElement() {
        return navigationBarHeaderElements;
    }

    public WebElement getHomeHeaderElement() {
        return homeHeaderElement;
    }

    public WebElement getContactFormHeaderElement() {
        return contactFormHeaderElement;
    }

    public WebElement getServiceHeaderElement() {
        return serviceHeaderElement;
    }

    public WebElement getMetalColorsHeaderElement() {
        return metalColorsHeaderElement;
    }

    public void clickOnServiceItem() {
        serviceHeaderElement.click();
    }
}
