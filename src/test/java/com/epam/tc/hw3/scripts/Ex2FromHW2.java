package com.epam.tc.hw3.scripts;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import com.epam.tc.hw4.scripts.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class Ex2FromHW2 extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    DifferentElementsPage differentElementsPage;

    SoftAssertions softAssertions = new SoftAssertions();

    //2 Assert Browser title
    @Test(priority = 1)
    public void testTitle() {
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
    }

    //3 Perform login
    //4 Assert User name in the left-top side of screen that user is loggined
    @Test(priority = 2)
    public void testLogin() {
        loginPage.initLoginPage(webDriver)
                .clickUserIcon().setUserName(USER_LOGIN).setUserPassword(USER_PASSWORD).clickLoginButton();
        softAssertions.assertThat(loginPage.initLoginPage(webDriver).getUserName().getText()).isEqualTo(USER_NAME);
    }

    //5 Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void goToDifferentElementsPage() {
        homePage = new HomePage(webDriver);
        homePage.getHeaderMenuComponent().getServiceHeaderElement().click();
        homePage.getDifferentElements().click();
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
    }

    //6 Select checkboxes
    @Test(priority = 4)
    public void testCheckBoxes() {
        differentElementsPage = new DifferentElementsPage(webDriver);
        differentElementsPage.getWaterCheckBox().click();
        differentElementsPage.getWindCheckBox().click();
        softAssertions.assertThat(differentElementsPage.getWaterCheckBox().isSelected()).isTrue();
        softAssertions.assertThat(differentElementsPage.getWindCheckBox().isSelected()).isTrue();
    }

    //7 Select radio
    @Test(priority = 5)
    public void testRadio() {
        differentElementsPage = new DifferentElementsPage(webDriver);
        differentElementsPage.getRadioSelen().click();
        softAssertions.assertThat(differentElementsPage.getRadioSelen().isSelected()).isTrue();
    }

    //8 Select in dropdown
    @Test(priority = 6)
    public void testDropDown() {
        differentElementsPage = new DifferentElementsPage(webDriver);
        differentElementsPage.getColorsDropDownComponent().clickOnDropDownColor();
        differentElementsPage.getColorsDropDownComponent().getYellowColor().click();
        softAssertions.assertThat(differentElementsPage.getColorsDropDownComponent().getYellowColor()
                .getText()).isEqualTo("Yellow");
    }

    //9.1 Assert that for each checkbox there is an individual log row and value is corresponded
    // to the status of checkbox
    //9.2 Assert that for radio button there is a log row and value is corresponded to the status of radio button
    //9.3 Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 7)
    public void testLogger() {
        differentElementsPage = new DifferentElementsPage(webDriver);
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
