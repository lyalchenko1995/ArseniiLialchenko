package com.epam.tc.hw7.pageObjects.tests;


import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.pageObjects.SiteJdi;
import com.epam.tc.hw7.pageObjects.entities.DTO;
import com.epam.tc.hw7.pageObjects.steps.StepsHW7;
import com.epam.tc.hw7.pageObjects.utils.MetalColorsDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.*;

import java.util.List;
import java.util.Map;

@Feature("Metals & Colors page feature")
@Story("Metals & Colors page story")
public class JdiTest {
    Map<String, DTO> mapFromJSON;

    @DataProvider(name = "json")
    public Object[][] dataProvider() {
        mapFromJSON = MetalColorsDataProvider.getDTOfromJSON();
        mapFromJSON.size();
        Object ars[][] = new Object[mapFromJSON.size()][mapFromJSON.entrySet().size()];
        int i = 0;
        for (Map.Entry<String, DTO> entry : mapFromJSON.entrySet()) {
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
