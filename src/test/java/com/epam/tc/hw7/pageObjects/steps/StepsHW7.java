package com.epam.tc.hw7.pageObjects.steps;

import com.epam.tc.hw7.pageObjects.SiteJdi;
import com.epam.tc.hw7.pageObjects.entities.DTO;
import com.epam.tc.hw7.pageObjects.utils.MetalColorsDataProvider;

import java.util.List;
import java.util.Map;

import static com.epam.tc.hw7.pageObjects.entities.User.ROMAN;

public class StepsHW7 {

    public static void loginJDI() {
        SiteJdi.openHomePage();
        SiteJdi.login(ROMAN);
        SiteJdi.homePageJdi.checkUserLoggedIn(ROMAN);
    }

    public static void navigateToMetalsColorsPage() {
        SiteJdi.homePageJdi.openMetalsColorsPage();
    }

    public static Map<String, DTO> getDatafromJSON() {
        return MetalColorsDataProvider.getDTOfromJSON();
    }

    public static void checkMetalsColorsForm(List<Integer> sum, List<String> el, String col, String met, List<String> veg) {
            SiteJdi.metalsColorsPageJdi.selectSummary(sum);
            SiteJdi.metalsColorsPageJdi.selectElements(el);
            SiteJdi.metalsColorsPageJdi.selectColors(col);
            SiteJdi.metalsColorsPageJdi.selectMetals(met);
            SiteJdi.metalsColorsPageJdi.selectVegetables(veg);
            SiteJdi.metalsColorsPageJdi.submit();
            SiteJdi.metalsColorsPageJdi.checkResultSection(sum, el,col,met,veg);
    }
}
