package com.epam.tc.hw7.pageObjects.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiDropdown;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MetalsColorsPageJdi extends WebPage {

    @FindBy(xpath = "//p[@class='radio'][contains(., '%s')]//label")
    public Menu summary;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metals;

    @UI("#vegetables")
    public MultiDropdown vegetables;

    @FindBy(xpath = "//p[@class='checkbox'][contains(., '%s')]//label")
    public UIElement elements;

    @UI("#submit-button")
    public Button submitButton;

    @FindBy(css = "ul[class='panel-body-list results'] > li")
    public List<WebElement> result;

    public void selectSummary(List<Integer> sum) {
        summary.select(sum.get(0));
        summary.select(sum.get(1));
    }

    public void selectElements(List<String> el) {
        for (String str : el) {
            elements.select(str);
        }
    }

    public void selectColors(String col) {
        colors.select(col);
    }

    public void selectMetals(String col) {
        metals.select(col);
    }

    public void selectVegetables(List<String> veg) {
        vegetables.select("Vegetables");
        for (String str : veg) {
            vegetables.select(str);
        }
    }


    public void submit() {
        submitButton.click();
    }

    public void checkResultSection() {


        System.out.println("222");
    }
}
