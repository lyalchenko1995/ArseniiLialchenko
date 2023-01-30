package com.epam.tc.hw7.steps;

import com.epam.tc.TestData;
import com.epam.tc.hw7.SiteJdi;
import com.epam.tc.hw7.entities.MetalsColorsJsonDTO;
import com.epam.tc.hw7.utils.MetalColorsDataProvider;

import java.util.Map;

public class StepsHW7 {

    public static void loginJDI() {
        SiteJdi.openHomePage();
        SiteJdi.login(TestData.ROMAN);
        SiteJdi.homePageJdi.checkUserLoggedIn(TestData.ROMAN);
    }

    public static void navigateToMetalsColorsPage() {
        SiteJdi.homePageJdi.openMetalsColorsPage();
    }

    public static Map<String, MetalsColorsJsonDTO> getDatafromJson() throws Exception {
        return MetalColorsDataProvider.getDTOfromJson();
    }


}
