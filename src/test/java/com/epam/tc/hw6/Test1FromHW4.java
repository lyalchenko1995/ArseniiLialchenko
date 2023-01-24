package com.epam.tc.hw6;

import com.epam.tc.hw4.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Home page feature")
@Story("Home page story")
public class Test1FromHW4 extends BaseTest {

    @Test
    @Description("Test home page")
    public void testHomePage() {
        assertSteps.assertTitle("Home Page");
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
