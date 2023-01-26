package com.epam.tc.hw7.pageObjects;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.pageObjects.entities.User;
import com.epam.tc.hw7.pageObjects.pages.HomePageJdi;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    @Url("/index.html")
    public static HomePageJdi homePageJdi;

    public static void open() {
        homePageJdi.open();
    }

    public static void login(User user) {
        homePageJdi.login(user);
    }

    public static String getUserName() {
        return homePageJdi.getUserName();
    }
}
