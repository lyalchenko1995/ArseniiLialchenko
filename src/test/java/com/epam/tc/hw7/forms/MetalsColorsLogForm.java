package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import java.util.ArrayList;
import java.util.List;

public class MetalsColorsLogForm extends Form {

    @FindBy(css = "ul[class='panel-body-list results'] > li")
    public WebList result;

    public List<String> getLogList() {
        List<String> logList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            logList.add(String.valueOf(result.get(i).getText()));
        }
        return logList;
    }
}
