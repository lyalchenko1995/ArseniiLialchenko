package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class MetalsColorsLogForm extends Form {

    @FindBy(css = "ul[class='panel-body-list results'] > li")
    public WebList result;

}
