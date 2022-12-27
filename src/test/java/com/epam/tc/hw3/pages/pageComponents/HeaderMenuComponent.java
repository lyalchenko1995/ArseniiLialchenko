package com.epam.tc.hw3.pages.pageComponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent {

    @FindBy(partialLinkText = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private WebElement navigationBarHeaderElement;

    @FindBy(partialLinkText = "HOME")
    private WebElement homeHeaderElement;

    @FindBy(partialLinkText = "CONTACT FORM")
    private WebElement contactFormHeaderElement;

    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderElement;

    @FindBy(partialLinkText = "METALS & COLORS")
    private WebElement metalColorsHeaderElement;

    public WebElement getNavigationBarHeaderElement() {
        return navigationBarHeaderElement;
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
}
