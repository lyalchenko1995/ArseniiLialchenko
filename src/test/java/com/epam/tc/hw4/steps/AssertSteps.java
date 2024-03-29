package com.epam.tc.hw4.steps;

import static com.epam.tc.hw4.tests.BaseTest.webDriver;

import com.epam.tc.hw4.utils.PageObjectInitialization;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AssertSteps extends PageObjectInitialization {

    public AssertSteps(WebDriver webDriver) {
        super(webDriver);
    }

    SoftAssertions softAssertions = new SoftAssertions();

    @Step("Assert page title")
    public void assertTitle(String title) {
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo(title);
        softAssertions.assertAll();
    }

    @Step("Assert login")
    public void assertLogin(String userName) {
        softAssertions.assertThat(loginPage.initLoginPage(webDriver).getUserName().getText()).isEqualTo(userName);
        softAssertions.assertAll();
    }

    @Step("Assert headers")
    public void assertHeaders() {
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getNavigationBarHeaderElement()
                .size()).isEqualTo(4);
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getHomeHeaderElement().isDisplayed());
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getContactFormHeaderElement().isDisplayed());
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getServiceHeaderElement().isDisplayed());
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getMetalColorsHeaderElement().isDisplayed());
    }

    @Step("Assert images")
    public void assertImages() {
        softAssertions.assertThat(homePage.getListOfImages().size()).isEqualTo(4);
        for (WebElement webElement : homePage.getListOfImages()) {
            webElement.isDisplayed();
        }
    }

    @Step("Assert texts for images")
    public void assertTextsForImages() {
        List<String> actualText = new ArrayList<>();
        for (WebElement webElement : homePage.getListOfTests()) {
            actualText.add(webElement.getText());
        }

        List<String> expectedText = Arrays.asList("To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                "To be flexible and\n"
                        + "customizable",
                "To be multiplatform",
                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…");

        softAssertions.assertThat(actualText.size()).isEqualTo(4);
        softAssertions.assertThat(actualText).isEqualTo(expectedText);
    }

    @Step("Assert iframe")
    public void assertIFrame() {
        softAssertions.assertThat(homePage.getFrameButton().isDisplayed());
    }

    @Step("Assert items in the left section")
    public void assertLeftSection() {
        List<String> actualText = new ArrayList<>();
        for (WebElement webElement : homePage.getSideMenuComponent().getSideMenuItems()) {
            actualText.add(webElement.getText());
        }

        List<String> expectedText = Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        softAssertions.assertThat(actualText.size()).isEqualTo(5);
        softAssertions.assertThat(actualText).isEqualTo(expectedText);
        softAssertions.assertAll();
    }

    @Step("Assert that checkbox is selected")
    public void assertCheckBoxIsSelected(String checkBoxName, boolean bool) {
        WebElement checkBoxElement = differentElementsPage.findElement(checkBoxName);
        if (bool = true) {
            softAssertions.assertThat(checkBoxElement.isSelected()).isTrue();
        } else {
            softAssertions.assertThat(checkBoxElement.isSelected()).isFalse();
        }
        softAssertions.assertAll();
    }

    @Step("Assert color")
    public void assertColor(String color) {
        softAssertions.assertThat(differentElementsPage.getColorsDropDownComponent().findColor(color)
                .getText()).isEqualTo(color);
    }

    @Step("Assert logs")
    public void assertLogs() {
        softAssertions.assertThat(differentElementsPage.getLogComponent().getLogs().size()).isEqualTo(4);
        softAssertions.assertThat(differentElementsPage.getLogComponent()
                .isNatureElementDisplayed("Water", "true")).isTrue();
        softAssertions.assertThat(differentElementsPage.getLogComponent()
                .isNatureElementDisplayed("Wind", "true")).isTrue();
        softAssertions.assertThat(differentElementsPage.getLogComponent()
                .isMetalOrColorDisplayed("metal", "Selen")).isTrue();
        softAssertions.assertThat(differentElementsPage.getLogComponent()
                .isMetalOrColorDisplayed("Colors", "Yellow")).isTrue();
        softAssertions.assertAll();
    }
}
