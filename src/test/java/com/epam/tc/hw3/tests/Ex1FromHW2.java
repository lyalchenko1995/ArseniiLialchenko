package com.epam.tc.hw3.tests;


import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import com.epam.tc.hw4.tests.BaseTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Ex1FromHW2 extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    SoftAssertions softAssertions = new SoftAssertions();

    //2 Assert Browser title
    @Test(priority = 1)
    public void testTitle() {
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
    }

    //3 Perform login
    //4 Assert Username is loggined
    @Test(priority = 2)
    public void testLogin() {
        loginPage.initLoginPage(webDriver)
                .clickUserIcon().setUserName(USER_LOGIN).setUserPassword(USER_PASSWORD).clickLoginButton();
        softAssertions.assertThat(loginPage.initLoginPage(webDriver).getUserName().getText()).isEqualTo(USER_NAME);
    }

    //5 Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 3)
    public void testHeaders() {
        homePage = new HomePage(webDriver);
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getNavigationBarHeaderElement()
                .size()).isEqualTo(4);
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getHomeHeaderElement().isDisplayed());
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getContactFormHeaderElement().isDisplayed());
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getServiceHeaderElement().isDisplayed());
        softAssertions.assertThat(homePage.getHeaderMenuComponent().getMetalColorsHeaderElement().isDisplayed());
    }

    //6 Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 4)
    public void testImages() {
        homePage = new HomePage(webDriver);
        softAssertions.assertThat(homePage.getListOfImages().size()).isEqualTo(4);
        for (WebElement webElement : homePage.getListOfImages()) {
            webElement.isDisplayed();
        }
    }

    //7 Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 5)
    public void testTextForImages() {
        homePage = new HomePage(webDriver);
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

    //8 Assert that there is the iframe with “Frame Button” exist
    //9 Switch to the iframe and check that there is “Frame Button” in the iframe
    //10 Switch to original window back
    @Test(priority = 6)
    public void testIframe() {
        homePage = new HomePage(webDriver);
        webDriver.switchTo().frame("frame");
        softAssertions.assertThat(homePage.getFrameButton().isDisplayed());
        webDriver.switchTo().defaultContent();
    }

    //11 Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 7)
    public void testSideMenu() {
        homePage = new HomePage(webDriver);
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
}
