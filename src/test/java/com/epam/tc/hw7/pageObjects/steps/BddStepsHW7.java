package com.epam.tc.hw7.pageObjects.steps;

import com.epam.tc.hw7.pageObjects.SiteJdi;
import com.epam.tc.hw7.pageObjects.entities.User;
import com.epam.tc.hw7.pageObjects.utils.PageObjectInitializationJDI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BddStepsHW7 extends PageObjectInitializationJDI {

    @Given("User logins on JDI site as User")
    public void user_logins_on_JDI_site_as_User() {
        SiteJdi.open();
        SiteJdi.login(User.ROMAN);
        String actualFullName = SiteJdi.getUserName();
        Assert.assertEquals(actualFullName, User.ROMAN.getFullName());
    }

    @And("User opens Metals & Colors page by Header menu")
    public void user_opens_Metal_Colors_page_by_Header_menu() {
    }

    @And("User fills form Metals & Colors by data")
    public void user_fills_form_Metals_Colors_by_data() {

    }

    @When("User submits form Metals & Colors")
    public void user_submits_form_Metals_Colors() {

    }

    @Then("Result sections should contains data")
    public void relults_section_should_contain_data() {

    }
}
