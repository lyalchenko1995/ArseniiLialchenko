package com.epam.tc.hw7.pageObjects.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.pageObjects.entities.User;
import com.epam.tc.hw7.pageObjects.forms.HeaderMenuFormJdi;
import com.epam.tc.hw7.pageObjects.forms.LoginFormJdi;

public class HomePageJdi extends WebPage {

    public LoginFormJdi loginFormJdi;
    public HeaderMenuFormJdi headerMenuFormJdi;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(id = "user-name")
    public Label userName;

    public void login(User user) {
        userIcon.click();
        loginFormJdi.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void checkUserLoggedIn(User user) {
        userName.is().text(user.getFullName());
    }

    public void openMetalsColorsPage() {
        headerMenuFormJdi.selectMetalsColorsMenu();
    }
}
