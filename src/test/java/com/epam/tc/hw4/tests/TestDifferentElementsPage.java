package com.epam.tc.hw4.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Different elements page feature")
@Story("Different elements page story")
public class TestDifferentElementsPage extends BaseTest {

    @Test
    @Description("Test different elements page")
    public void testDifferentElementsPage() {
        assertSteps.assertTitle("Home Page");
        actionSteps.login(USER_LOGIN, USER_PASSWORD);
        assertSteps.assertLogin(USER_NAME);
        actionSteps.navigateToDifferentElementsPage();
        assertSteps.assertTitle("Different Elements");
        actionSteps.clickOnCheckBox("Water");
        assertSteps.assertCheckBoxIsSelected("Water", true);
        actionSteps.clickOnCheckBox("Wind");
        assertSteps.assertCheckBoxIsSelected("Wind", true);
        actionSteps.clickOnCheckBox("Selen");
        assertSteps.assertCheckBoxIsSelected("Selen", true);
        actionSteps.selectColor("Yellow");
        assertSteps.assertColor("Yellow");
        assertSteps.assertLogs();
    }
}
