package com.epam.tc.hw5.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePageHW5 extends MainPageHW5 {

    public UserTablePageHW5(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "tbody > tr")
    private List<WebElement> listTypeDropdowns;

    @FindBy(css = "td > a")
    private List<WebElement> listUsers;

    @FindBy(css = ".user-descr")
    private List<WebElement> listImages;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private List<WebElement> listCheckboxes;

    @FindBy(xpath = "//*[@class = 'panel-body-list logs']//li")
    private List<WebElement> logs;

    @FindBy(css = "[class='user-descr']")
    private List<WebElement> descInTable;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> numberInTable;

    public List<WebElement> getlistTypeDropdowns() {
        return listTypeDropdowns;
    }

    public List<WebElement> getListUsers() {
        return listUsers;
    }

    public List<WebElement> getListImages() {
        return listImages;
    }

    public List<WebElement> getListCheckboxes() {
        return listCheckboxes;
    }

    public void userRightsDropdown(String value) {
        listTypeDropdowns.get(0).click();
        WebElement dropdown = webDriver.findElement(By.xpath("//select/option[contains(. ,'" + value + "')]"));
        elementIsDisplayed(dropdown);
    }

    public void selectVipCheckBox(String checkboxOption) {
        WebElement checkBox = webDriver.findElement(By.xpath("//*[@id = '" + checkboxOption + "']"));
        checkBox.click();
    }

    public void assertNumberOfLogItems(int numOfLogs) {
        assertThat(logs.size()).isEqualTo(numOfLogs);
    }

    public void assertLogText(String logText) {
        WebElement log = webDriver.findElement(By.xpath("//li[contains(. ,'" + logText + "')]"));
        elementIsDisplayed(log);
    }

    public List<String> getUserInTableValues() {
        return listUsers.stream()
                .map(u -> u.getText())
                .collect(Collectors.toList());
    }

    public List<String> getNumberInTableValues() {
        return numberInTable.stream()
                .map(n -> n.getText())
                .collect(Collectors.toList());
    }

    public List<String> getDescInTableValues() {
        return descInTable.stream()
                .map(n -> n.getText())
                .map(n -> n.trim())
                .map(n -> n.replaceAll("\\s", " "))
                .map(n -> n.replaceAll("Vip", " "))
                .map(n -> n.trim())
                .collect(Collectors.toList());
    }
}
