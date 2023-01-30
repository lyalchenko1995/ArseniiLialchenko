package com.epam.tc.hw7.tests;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.SiteJdi;
import com.epam.tc.hw7.entities.DTO;
import com.epam.tc.hw7.steps.StepsHW7;
import com.epam.tc.hw7.utils.MetalColorsDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("Metals & Colors page feature")
@Story("Metals & Colors page story")
public class JdiTest {
    Map<String, DTO> mapFromJson;

    @DataProvider(name = "json")
    public Object[][] dataProvider() {
        mapFromJson = MetalColorsDataProvider.getDTOfromJson();
        mapFromJson.size();
        Object[][] ars = new Object[mapFromJson.size()][mapFromJson.entrySet().size()];
        int i = 0;
        for (Map.Entry<String, DTO> entry : mapFromJson.entrySet()) {
            entry.getValue();
            ars[i][0] = entry.getValue().summary;
            ars[i][1] = entry.getValue().elements;
            ars[i][2] = entry.getValue().color;
            ars[i][3] = entry.getValue().metals;
            ars[i][4] = entry.getValue().vegetables;
            i++;
        }
        return ars;
    }

    @BeforeTest(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(SiteJdi.class);
        StepsHW7.loginJDI();
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "json")
    public void testMetalsColors(List<Integer> sum, List<String> el, String col, String met, List<String> veg) {
        StepsHW7.navigateToMetalsColorsPage();
        StepsHW7.checkMetalsColorsForm(sum, el, col, met, veg);
    }
}
