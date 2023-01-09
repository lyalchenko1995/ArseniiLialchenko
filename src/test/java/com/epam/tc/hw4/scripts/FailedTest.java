package com.epam.tc.hw4.scripts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class FailedTest extends BaseTest {
    @Test
    @Description("Test home page")
    public void testHomePage() {
        assertStep.assertTitle("Home Page");
        actionStep.login(USER_LOGIN, USER_PASSWORD);
        assertStep.assertLogin("Ars"); //fail
        assertStep.assertHeaders();
        assertStep.assertImages();
        assertStep.assertTextsForImages();
        actionStep.switchToIFrame();
        assertStep.assertIFrame();
        actionStep.switchToOriginalWindow();
        assertStep.assertLeftSection();
    }
}
