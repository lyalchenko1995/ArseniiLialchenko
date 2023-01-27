package com.epam.tc.hw7.pageObjects.steps;

import com.epam.tc.hw7.pageObjects.SiteJdi;
import com.epam.tc.hw7.pageObjects.entities.User;
import org.testng.Assert;

public class StepsHW7 {

    public static void loginJDI() {
        SiteJdi.open();
        SiteJdi.login(User.ROMAN);
        String actualFullName = SiteJdi.getUserName();
        Assert.assertEquals(actualFullName, User.ROMAN.getFullName());
    }

}
