package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.RunCloseWebSite;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestsExercise1 extends RunCloseWebSite {

    //2 Assert Browser title
    @Test(priority = 1)
    public void testTitle() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        softAssertions.assertAll();
    }

    //3 Perform login
    //4 Assert Username is loggined
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

    //5 Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 3)
    public void testHeaders() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.findElement(By.partialLinkText("HOME")).getText())
                .isEqualTo("HOME");
        softAssertions.assertThat(webDriver.findElement(By.partialLinkText("CONTACT FORM")).getText())
                .isEqualTo("CONTACT FORM");
        softAssertions.assertThat(webDriver.findElement(By.partialLinkText("SERVICE")).getText())
                .isEqualTo("SERVICE");
        softAssertions.assertThat(webDriver.findElement(By.partialLinkText("METALS & COLORS")).getText())
                .isEqualTo("METALS & COLORS");
        softAssertions.assertAll();
    }

    //6 Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 4)
    public void testImages() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.findElements(By.cssSelector("[class='icons-benefit icon-practise']")))
                .isNotEmpty();
        softAssertions.assertThat(webDriver.findElements(By.cssSelector("[class='icons-benefit icon-custom']")))
                .isNotEmpty();
        softAssertions.assertThat(webDriver.findElements(By.cssSelector("[class='icons-benefit icon-multi']")))
                .isNotEmpty();
        softAssertions.assertThat(webDriver.findElements(By.cssSelector("[class='icons-benefit icon-base']")))
                .isNotEmpty();
        softAssertions.assertAll();
    }

    //7 Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 5)
    public void testTextForImages() {
        By text1 = new By.ByXPath(".//*[@class='icons-benefit icon-practise']/..//../span[@class = 'benefit-txt']");
        By text2 = new By.ByXPath(".//*[@class='icons-benefit icon-custom']/..//../span[@class = 'benefit-txt']");
        By text3 = new By.ByXPath(".//*[@class='icons-benefit icon-multi']/..//../span[@class = 'benefit-txt']");
        By text4 = new By.ByXPath(".//*[@class='icons-benefit icon-base']/..//../span[@class = 'benefit-txt']");

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.findElement(text1).getText()).isEqualTo("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        softAssertions.assertThat(webDriver.findElement(text2).getText()).isEqualTo("To be flexible and\n"
                + "customizable");
        softAssertions.assertThat(webDriver.findElement(text3).getText()).isEqualTo("To be multiplatform");
        softAssertions.assertThat(webDriver.findElement(text4).getText()).isEqualTo("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");
        softAssertions.assertAll();
    }

    //8 Assert that there is the iframe with “Frame Button” exist
    //9 Switch to the iframe and check that there is “Frame Button” in the iframe
    //10 Switch to original window back
    @Test(priority = 6)
    public void testIframe() {
        webDriver.switchTo().frame("frame");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.findElements(By.id("frame-button"))).isNotEmpty();
        softAssertions.assertAll();
        webDriver.switchTo().defaultContent();
    }

    //11 Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 7)
    public void testSideMenu() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(webDriver.findElement(
                new By.ByXPath("//*[@class='sidebar-menu left']//li[@index='1']//span[text()='Home']")
                )
                .getText()).isEqualTo("Home");
        softAssertions.assertThat(webDriver.findElement(
                new By.ByXPath("//*[@class='sidebar-menu left']//li[@index='2']//span[text()='Contact form']")
                )
                .getText()).isEqualTo("Contact form");
        softAssertions.assertThat(webDriver.findElement(
                new By.ByXPath("//*[@class='sidebar-menu left']//li[@index='3']//span[text()='Service']")
                )
                .getText()).isEqualTo("Service");
        softAssertions.assertThat(webDriver.findElement(
                new By.ByXPath("//*[@class='sidebar-menu left']//li[@index='4']//span[text()='Metals & Colors']")
                )
                .getText()).isEqualTo("Metals & Colors");
        softAssertions.assertThat(webDriver.findElement(
                new By.ByXPath("//*[@class='sidebar-menu left']//li[@index='5']//span[text()='Elements packs']")
                )
                .getText()).isEqualTo("Elements packs");
        softAssertions.assertAll();
    }
}
