package com.epam.tc.hw4.scripts;

import com.epam.tc.hw4.BaseTestHW4;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Feature1")
@Story("Story1")
public class Ex1 extends BaseTestHW4 {

    @Test
    @Description("Test home page")
    public void testHomePage() {
        assertStep.assertTitle("Home Page");
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
