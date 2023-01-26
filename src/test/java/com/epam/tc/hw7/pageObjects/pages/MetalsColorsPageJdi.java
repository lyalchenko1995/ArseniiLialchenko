package com.epam.tc.hw7.pageObjects.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;

public class MetalsColorsPageJdi extends WebPage {

    @Css("#summary-block")
    public Menu summary;

    @Css("#colors")
    public Dropdown colors;

    @Css("#colors")
    public Dropdown metals;

    @Css("#vegetables")
    public Dropdown vegetables;

    @Css("#elements-block")
    public MultiSelector elements;
}
