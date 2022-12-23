package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.WebSiteInitialization;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestsExercise1 extends WebSiteInitialization {

    SoftAssertions softAssertions = new SoftAssertions();
    static final String HEADER_MENU_PATH = "ul.uui-navigation.nav.navbar-nav.m-l8 > li";
    static final String SIDE_BAR_MENU = "ul[class='sidebar-menu left'] > li";
    static final String CSS_SELECTOR_PRACTISE = "[class='icons-benefit icon-practise']";
    static final String CSS_SELECTOR_CUSTOM = "[class='icons-benefit icon-custom']";
    static final String CSS_SELECTOR_MULTI = "[class='icons-benefit icon-multi']";
    static final String CSS_SELECTOR_BASE = "[class='icons-benefit icon-base']";

    //2 Assert Browser title
    @Test(priority = 1)
    public void testTitle() {
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
    }

    //3 Perform login
    //4 Assert Username is loggined
    @Test(priority = 2)
    public void testLogin() {
        findElementBySelector(By.id("user-icon")).click();
        findElementBySelector(By.id("name")).sendKeys(USER_LOGIN);
        findElementBySelector(By.id("password")).sendKeys(USER_PASSWORD);
        findElementBySelector(By.id("login-button")).click();

        WebElement user = findElementBySelector(By.id("user-name"));
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(user));
        softAssertions.assertThat(user.getText()).isEqualTo(USER_NAME);
    }

    //5 Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 3)
    public void testHeaders() {
        List<WebElement> headerElements = findElementsBySelector(By.cssSelector(HEADER_MENU_PATH));
        softAssertions.assertThat(headerElements.size()).isEqualTo(4);
        softAssertions.assertThat(findElementBySelector(By.partialLinkText("HOME")).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.partialLinkText("CONTACT FORM")).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.partialLinkText("SERVICE")).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.partialLinkText("METALS & COLORS")).isDisplayed());
    }

    //6 Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 4)
    public void testImages() {
        List<WebElement> imagesOnIndexPage = findElementsBySelector(By.className("benefit-icon"));
        softAssertions.assertThat(imagesOnIndexPage.size()).isEqualTo(4);
        softAssertions.assertThat(findElementBySelector(By.cssSelector(CSS_SELECTOR_PRACTISE)).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.cssSelector(CSS_SELECTOR_CUSTOM)).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.cssSelector(CSS_SELECTOR_MULTI)).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.cssSelector(CSS_SELECTOR_BASE)).isDisplayed());
    }

    //7 Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 5)
    public void testTextForImages() {
        List<WebElement> textElements = findElementsBySelector(By.className("benefit-txt"));
        List<String> actualText = new ArrayList<>();
        for (WebElement webElement : textElements) {
            actualText.add(webElement.getText());
        }
        List<String> expectedText = new ArrayList<>();
        expectedText.add("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        expectedText.add("To be flexible and\n"
                + "customizable");
        expectedText.add("To be multiplatform");
        expectedText.add("Already have good base\n"
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
        webDriver.switchTo().frame("frame");
        softAssertions.assertThat(findElementBySelector(By.id("frame-button")).isDisplayed());
        webDriver.switchTo().defaultContent();
    }

    //11 Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 7)
    public void testSideMenu() {
        List<String> expectedText = new ArrayList<>();
        expectedText.add("Home");
        expectedText.add("Contact form");
        expectedText.add("Service");
        expectedText.add("Metals & Colors");
        expectedText.add("Elements packs");

        List<WebElement> menuElements = findElementsBySelector(By.cssSelector(SIDE_BAR_MENU));
        List<String> actualText = new ArrayList<>();
        for (WebElement webElement : menuElements) {
            actualText.add(webElement.getText());
        }

        softAssertions.assertThat(actualText.size()).isEqualTo(5);
        softAssertions.assertThat(actualText).isEqualTo(expectedText);
        softAssertions.assertAll();
    }
}
