package com.epam.tc.hw4.scripts;

import com.epam.tc.hw4.BaseTestHW4;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class FailedTest extends BaseTestHW4 {
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
