package com.nc.edu.ta.doroshenkodenis.steps;

import com.nc.edu.ta.doroshenkodenis.helpers.DataGenerator;
import com.nc.edu.ta.doroshenkodenis.pages.SetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Registration extends SetUp {

    @Before("@RegTest")
    public void initialization() {
        setUpEnvironment();
    }

//    @BeforeStep("@RegTest")
//    public void beforeStep() {
//        takeScreenshot();
//    }

    @After("@RegTest")
    public void afterScenario() {
        tearDown();
    }

    @Given("user navigates to registration page by opening Chrome")
    public void userNavigatesToRegistrationPageByOpeningChrome() {
        regPage
                .openRegPage()
                .checkIsRegPage();
    }

    String generatedUserName;
    @When("user enter {string} in the Username field")
    public void userEnterInTheUsernameField(String username) {
        generatedUserName = username + DataGenerator.getRandomAlphanumeric(6);
        regPage.setUserName(generatedUserName);
    }

    @And("user enter {string} in the Password field")
    public void userEnterInThePasswordField(String pass) {
        regPage.setPassword(pass);
    }

    @And("user enter {string} in the Repeat Password field")
    public void userEnterInTheRepeatPasswordField(String repeatedPass) {
        regPage.setConfirmPassword(repeatedPass);
    }

    @And("user enter {string} in the Email field")
    public void userEnterInTheEmailField(String email) {
        regPage.setEmail(generatedUserName + email);
    }

    @And("user select {string} from Role dropdown")
    public void userSelectFromRoleDropdown(String role) {
        regPage.setRole(role);
    }

    @And("user press the Registration button")
    public void userPressTheRegistrationButton() {
        regPage.sentRegistrationData();
    }

    @Then("user should see successful notification on the Login page")
    public void userShouldSeeSuccessfulNotificationOnTheLoginPage() {
        Assert.assertTrue(loginPage.justRegistered()); ;
    }

    @When("user enter Username in the Username field on the Login page")
    public void userEnterUsernameInTheUsernameFieldOnTheLoginPage() {
        loginPage.setUserName(generatedUserName);
    }

    @And("user enter {string} in the Password field on the Login page")
    public void userEnterInThePasswordFieldOnTheLoginPage(String pass) {
        loginPage.setPassword(pass);
    }

    @And("user press the Login button")
    public void userPressTheLoginButton() {
        loginPage.goToStartPage();
    }

    @Then("user should see the current Username on the Start page")
    public void userShouldSeeTheCurrentUsernameOnTheStartPage() {
        startPage.checkLogin(generatedUserName);
    }

}
