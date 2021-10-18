package com.nc.edu.ta.doroshenkodenis.steps;

import com.nc.edu.ta.doroshenkodenis.pages.SetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HintsCheckingTest extends SetUp {

    @Before("@HintsTest")
    public void initialization() {
        setUpEnvironment();
    }

    @After("@HintsTest")
    public void afterScenario() {
        tearDown();
    }

    @Given("user navigates to registration page by Chrome")
    public void userNavigatesToRegistrationPageByChrome() {
        regPage.openRegPage();
    }

    @Then("the user points the mouse on the hint in the {string} field AND see the {string}")
    public void theUserPointsTheMouseOnTheHintInTheFieldANDSeeThe(String field, String text) {
        String hintText = regPage.getTextFromElementByFieldName(field);
        Assert.assertEquals(hintText,text);
    }
}
