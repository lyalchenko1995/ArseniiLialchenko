package com.epam.tc.hw7.steps;

import com.epam.tc.hw7.SiteJdi;
import com.epam.tc.hw7.entities.DTO;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.utils.MetalColorsDataProvider;
import java.util.List;
import java.util.Map;

public class StepsHW7 {

    public static void loginJDI() {
        SiteJdi.openHomePage();
        SiteJdi.login(User.ROMAN);
        SiteJdi.homePageJdi.checkUserLoggedIn(User.ROMAN);
    }

    public static void navigateToMetalsColorsPage() {
        SiteJdi.homePageJdi.openMetalsColorsPage();
    }

    public static Map<String, DTO> getDatafromJson() {
        return MetalColorsDataProvider.getDTOfromJson();
    }

    public static void checkMetalsColorsForm(List<Integer> sum, List<String> el,
                                             String col, String met, List<String> veg) {
        SiteJdi.metalsColorsPageJdi.selectSummary(sum);
        SiteJdi.metalsColorsPageJdi.selectElements(el);
        SiteJdi.metalsColorsPageJdi.selectColors(col);
        SiteJdi.metalsColorsPageJdi.selectMetals(met);
        SiteJdi.metalsColorsPageJdi.selectVegetables(veg);
        SiteJdi.metalsColorsPageJdi.submit();
        SiteJdi.metalsColorsPageJdi.checkResultSection(sum, el, col, met, veg);
    }
}
