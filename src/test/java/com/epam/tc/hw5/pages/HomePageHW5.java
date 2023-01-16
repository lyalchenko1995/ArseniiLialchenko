package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.HeaderMenuComponentHW5;
import com.epam.tc.hw5.pages.components.SideMenuComponentHW5;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHW5 extends MainPageHW5 {

    private HeaderMenuComponentHW5 headerMenuComponent;

    private SideMenuComponentHW5 sideMenuComponent;

    @FindBy(css = "[class='icons-benefit icon-practise']")
    private WebElement iconPractise;

    @FindBy(css = "[class='icons-benefit icon-custom']")
    private WebElement iconCustom;

    @FindBy(css = "[class='icons-benefit icon-multi']")
    private WebElement iconMulti;

    @FindBy(css = "[class='icons-benefit icon-base']")
    private WebElement iconBase;

    @FindBy(className = "benefit-icon")
    private List<WebElement> listOfImages;


    @FindBy(className = "benefit-txt")
    private List<WebElement> listOfTests;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    public HomePageHW5(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        headerMenuComponent = new HeaderMenuComponentHW5();
        sideMenuComponent = new SideMenuComponentHW5();
        PageFactory.initElements(webDriver, headerMenuComponent);
        PageFactory.initElements(webDriver, sideMenuComponent);
    }

    public HeaderMenuComponentHW5 getHeaderMenuComponent() {
        return headerMenuComponent;
    }

    public SideMenuComponentHW5 getSideMenuComponent() {
        return sideMenuComponent;
    }

    public WebElement getIconPractise() {
        return iconPractise;
    }

    public WebElement getIconCustom() {
        return iconCustom;
    }

    public WebElement getIconMulti() {
        return iconMulti;
    }

    public WebElement getIconBase() {
        return iconBase;
    }

    public List<WebElement> getListOfImages() {
        return listOfImages;
    }

    public List<WebElement> getListOfTests() {
        return listOfTests;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public WebElement getDifferentElements() {
        return differentElements;
    }

    public void openHomePage() {
        webDriver.manage().window().maximize();
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public void clickServiceMenuItem(String item) {
        WebElement serviceMenuItem = webDriver.findElement(By.xpath("//a[contains(text(),'" + item + "')]"));
        serviceMenuItem.click();
    }
}
