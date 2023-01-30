package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiDropdown;
import java.util.List;

import com.epam.tc.hw7.SiteJdi;
import org.testng.Assert;

public class MetalsColorsForm extends Form {

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
    public WebList result;

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

    public static void checkMetalsColorsForm(List<Integer> sum, List<String> el,
                                             String col, String met, List<String> veg) {
        SiteJdi.metalsColorsForm.selectSummary(sum);
        SiteJdi.metalsColorsForm.selectElements(el);
        SiteJdi.metalsColorsForm.selectColors(col);
        SiteJdi.metalsColorsForm.selectMetals(met);
        SiteJdi.metalsColorsForm.selectVegetables(veg);
        SiteJdi.metalsColorsForm.submit();
        SiteJdi.metalsColorsForm.checkResultSection(sum, el, col, met, veg);
    }

    public void submit() {
        submitButton.click();
    }

    public void checkResultSection(List<Integer> sum, List<String> el, String col, String met, List<String> veg) {
        String expectedSummary = "Summary: " + String.valueOf(sum.get(0) + sum.get(1));
        Assert.assertTrue(result.get(1).getText().equals(expectedSummary));

        for (String str : el) {
            Assert.assertTrue(result.get(2).getText().contains(str));
        }

        Assert.assertTrue(result.get(3).getText().equals("Color: " + col));

        Assert.assertTrue(result.get(4).getText().equals("Metal: " + met));

        for (String str : veg) {
            Assert.assertTrue(result.get(5).getText().contains(str));
        }
    }
}
