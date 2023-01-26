package com.epam.tc.hw7.pageObjects.forms;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class HeaderMenuFormJdi extends Form {

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] > li")
    public Menu navigation;

}
