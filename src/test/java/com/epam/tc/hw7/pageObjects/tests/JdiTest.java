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
        return new Object[][]{
                {mapFromJSON.get("data_1").summary, mapFromJSON.get("data_1").elements, mapFromJSON.get("data_1").color,
                        mapFromJSON.get("data_1").metals,mapFromJSON.get("data_1").vegetables}
                ,
                {mapFromJSON.get("data_2").summary, mapFromJSON.get("data_2").elements, mapFromJSON.get("data_2").color,
                        mapFromJSON.get("data_2").metals,mapFromJSON.get("data_2").vegetables},
                {mapFromJSON.get("data_3").summary, mapFromJSON.get("data_3").elements, mapFromJSON.get("data_3").color,
                        mapFromJSON.get("data_3").metals,mapFromJSON.get("data_3").vegetables},
                {mapFromJSON.get("data_4").summary, mapFromJSON.get("data_4").elements, mapFromJSON.get("data_4").color,
                        mapFromJSON.get("data_4").metals,mapFromJSON.get("data_4").vegetables},
                {mapFromJSON.get("data_5").summary, mapFromJSON.get("data_5").elements, mapFromJSON.get("data_5").color,
                        mapFromJSON.get("data_5").metals,mapFromJSON.get("data_5").vegetables}
        };
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
   public void testMetalsColors(List<Integer> sum, List<String> el,String col,String met,List<String> veg){

        StepsHW7.navigateToMetalsColorsPage();
        StepsHW7.checkMetalsColorsForm(sum, el, col,met, veg);
    }
}
