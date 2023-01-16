package com.epam.tc.hw4.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Home page feature")
@Story("Home page story")
public class FailedTest extends BaseTest {
    @Test
    @Description("Failed test")
    public void testHomePage() {
        assertSteps.assertTitle("Home Page1");
        actionSteps.login(USER_LOGIN, USER_PASSWORD);
        assertSteps.assertLogin(USER_NAME);
        assertSteps.assertHeaders();
        assertSteps.assertImages();
        assertSteps.assertTextsForImages();
        actionSteps.switchToIFrame();
        assertSteps.assertIFrame();
        actionSteps.switchToOriginalWindow();
        assertSteps.assertLeftSection();
    }
}
