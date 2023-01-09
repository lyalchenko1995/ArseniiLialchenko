package com.epam.tc.hw4.scripts;

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
        assertStep.assertTitle("Home Page1");
        actionStep.login(USER_LOGIN, USER_PASSWORD);
        assertStep.assertLogin(USER_NAME);
        assertStep.assertHeaders();
        assertStep.assertImages();
        assertStep.assertTextsForImages();
        actionStep.switchToIFrame();
        assertStep.assertIFrame();
        actionStep.switchToOriginalWindow();
        assertStep.assertLeftSection();
    }
}
