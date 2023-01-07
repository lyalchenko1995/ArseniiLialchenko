package com.epam.tc.hw4.scripts;

import com.epam.tc.hw4.BaseTestHW4;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Feature2")
@Story("Story2")
public class Ex2 extends BaseTestHW4 {

    @Test
    @Description("Test dirrefent elements page")
    public void testDifferentElementsPage() {
        assertStep.assertTitle("Home Page");
        actionStep.login(USER_LOGIN, USER_PASSWORD);
        assertStep.assertLogin(USER_NAME);
        actionStep.navigateToDifferentElementsPage();
        assertStep.assertTitle("Different Elements");
        actionStep.clickOnCheckBox("Water");
        assertStep.assertCheckBoxIsSelected("Water", true);
        actionStep.clickOnCheckBox("Wind");
        assertStep.assertCheckBoxIsSelected("Wind", true);
        actionStep.clickOnCheckBox("Selen");
        assertStep.assertCheckBoxIsSelected("Selen", true);
        actionStep.selectColor("Yellow");
        assertStep.assertColor("Yellow");
        assertStep.assertLogs();
    }
}
