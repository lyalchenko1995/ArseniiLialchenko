package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.WebSiteInitialization;
import java.time.Duration;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestsExercise2 extends WebSiteInitialization {

    SoftAssertions softAssertions = new SoftAssertions();
    static final String LOG_PATH = "ul[class='panel-body-list logs'] > li";
    static final String WATER_CHECKBOX_PATH = "//label[@class='label-checkbox'][1]/*";
    static final String WIND_CHECKBOX_PATH = "//label[@class='label-checkbox'][3]/*";
    static final String RADIO_SELEN_PATH = "//label[@class='label-radio'][4]/*";
    static final String COLOR_DROPDOWN_PATH = ".//*[@class='colors']//*[@class='uui-form-element']";
    static final String YELLOW_COLOR_PATH =
            ".//*[@class='colors']//*[@class='uui-form-element']//option[text() = 'Yellow']";
    static final String WATER_LOG_PATH = "//*[contains(text(),'Water: condition changed to true')]";
    static final String WIND_LOG_PATH = "//*[contains(text(),'Wind: condition changed to true')]";
    static final String METAL_LOG_PATH = "//*[contains(text(),'metal: value changed to  Selen')]";
    static final String COLORS_LOG_PATH = "//*[contains(text(),'Colors: value changed to Yellow')]";

    //2 Assert Browser title
    @Test(priority = 1)
    public void testTitle() {
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
    }

    //3 Perform login
    //4 Assert User name in the left-top side of screen that user is loggined
    @Test(priority = 2)
    public void testLogin() {
        findElementBySelector(By.id("user-icon")).click();
        findElementBySelector(By.id("name")).sendKeys(USER_LOGIN);
        findElementBySelector(By.id("password")).sendKeys(USER_PASSWORD);
        findElementBySelector(By.id("login-button")).click();

        WebElement user = findElementBySelector(By.id("user-name"));
        //new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(user));
        softAssertions.assertThat(user.getText()).isEqualTo(USER_NAME);
    }

    //5 Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void goToDifferentElementsPage() {
        findElementBySelector(By.partialLinkText("SERVICE")).click();
        findElementBySelector(By.partialLinkText("DIFFERENT ELEMENTS")).click();
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
    }

    //6 Select checkboxes
    @Test(priority = 4)
    public void testCheckBoxes() {
        WebElement waterCheckBox = findElementBySelector(By.xpath(WATER_CHECKBOX_PATH));
        waterCheckBox.click();
        WebElement windCheckBox = findElementBySelector(By.xpath(WIND_CHECKBOX_PATH));
        windCheckBox.click();
        softAssertions.assertThat(waterCheckBox.isSelected()).isTrue();
        softAssertions.assertThat(windCheckBox.isSelected()).isTrue();
    }

    //7 Select radio
    @Test(priority = 5)
    public void testRadio() {
        WebElement radioSelen = findElementBySelector(By.xpath(RADIO_SELEN_PATH));
        radioSelen.click();
        softAssertions.assertThat(radioSelen.isSelected()).isTrue();
    }

    //8 Select in dropdown
    @Test(priority = 6)
    public void testDropDown() {
        WebElement colors = findElementBySelector(By.xpath(COLOR_DROPDOWN_PATH));
        colors.click();
        WebElement yellow = findElementBySelector(By.xpath(YELLOW_COLOR_PATH));
        yellow.click();
        softAssertions.assertThat(yellow.getText()).isEqualTo("Yellow");
    }

    //9.1 Assert that for each checkbox there is an individual log row and value is corresponded
    // to the status of checkbox
    //9.2 Assert that for radio button there is a log row and value is corresponded to the status of radio button
    //9.3 Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 7)
    public void testLogger() {
        List<WebElement> headerElements = findElementsBySelector(By.cssSelector(LOG_PATH));
        softAssertions.assertThat(headerElements.size()).isEqualTo(4);
        softAssertions.assertThat(findElementBySelector(By.xpath(WATER_LOG_PATH)).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.xpath(WIND_LOG_PATH)).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.xpath(METAL_LOG_PATH)).isDisplayed());
        softAssertions.assertThat(findElementBySelector(By.xpath(COLORS_LOG_PATH)).isDisplayed());
        softAssertions.assertAll();
    }
}
