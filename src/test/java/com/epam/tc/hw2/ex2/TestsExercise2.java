package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.RunCloseWebSite;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestsExercise2 extends RunCloseWebSite {

    //2 Assert Browser title
    @Test(priority = 1)
    public void testTitle() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        softAssertions.assertAll();
    }

    //3 Perform login
    //4 Assert User name in the left-top side of screen that user is loggined
    @Test(priority = 2)
    public void testLogin() {
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");
        softAssertions.assertAll();
    }

    //5 Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void goToDifferentElementsPage() {
        webDriver.findElement(By.partialLinkText("SERVICE")).click();
        webDriver.findElement(By.partialLinkText("DIFFERENT ELEMENTS")).click();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
        softAssertions.assertAll();
    }

    //6 Select checkboxes
    @Test(priority = 4)
    public void testCheckBoxes() {
        WebElement waterCheckBox = webDriver.findElement(new By.ByXPath("//label[@class='label-checkbox'][1]/*"));
        waterCheckBox.click();
        WebElement windCheckBox = webDriver.findElement(new By.ByXPath("//label[@class='label-checkbox'][3]/*"));
        windCheckBox.click();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(waterCheckBox.isSelected()).isTrue();
        softAssertions.assertThat(windCheckBox.isSelected()).isTrue();
        softAssertions.assertAll();
    }

    //7 Select radio
    @Test(priority = 5)
    public void testRadio() {
        WebElement radioSelen = webDriver.findElement(new By.ByXPath("//label[@class='label-radio'][4]/*"));
        radioSelen.click();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(radioSelen.isSelected()).isTrue();
        softAssertions.assertAll();
    }

    //8 Select in dropdown
    @Test(priority = 6)
    public void testDropDown() {
        By dropDown = new By.ByXPath(".//*[@class='colors']//*[@class='uui-form-element']");
        WebElement colors  = webDriver.findElement(dropDown);
        colors.click();
        WebElement yellow = webDriver.findElement(
                new By.ByXPath(".//*[@class='colors']//*[@class='uui-form-element']//option[text() = 'Yellow']"));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(yellow.getText()).isEqualTo("Yellow");
        softAssertions.assertAll();
    }

    //9.1 Assert that for each checkbox there is an individual log row and value is corresponded
    // to the status of checkbox
    //9.2 Assert that for radio button there is a log row and value is corresponded to the status of radio button
    //9.3 Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 7)
    public void testLogger() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.findElements(
                new By.ByXPath("//*[contains(text(),'Water: condition changed to true')]"))).isNotEmpty();
        softAssertions.assertThat(webDriver.findElements(
                new By.ByXPath("//*[contains(text(),'Wind: condition changed to true')]"))).isNotEmpty();
        softAssertions.assertThat(webDriver.findElements(
                new By.ByXPath("//*[contains(text(),'metal: value changed to  Selen')]"))).isNotEmpty();
        softAssertions.assertThat(webDriver.findElements(
                new By.ByXPath("//*[contains(text(),'Colors: value changed to Yellow')]"))).isNotEmpty();
    }
}
