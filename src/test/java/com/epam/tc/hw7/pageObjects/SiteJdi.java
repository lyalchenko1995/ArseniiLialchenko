package com.epam.tc.hw7.pageObjects;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.pageObjects.entities.User;
import com.epam.tc.hw7.pageObjects.pages.HomePageJdi;
import com.epam.tc.hw7.pageObjects.pages.MetalsColorsPageJdi;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    @Url("index.html")
    public static HomePageJdi homePageJdi;

    @Url("metals-colors.html")
    public static MetalsColorsPageJdi metalsColorsPageJdi;

    public static void openHomePage() {
        homePageJdi.open();
    }

    public static void login(User user) {
        homePageJdi.login(user);
    }

    public static String getUserName() {
        return homePageJdi.getUserName();
    }
}
