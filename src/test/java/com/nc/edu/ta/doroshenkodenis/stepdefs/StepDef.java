package com.nc.edu.ta.doroshenkodenis.stepdefs;

import com.nc.edu.ta.doroshenkodenis.helpers.DataGenerator;
import com.nc.edu.ta.doroshenkodenis.pages.SetUp;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Objects;

public class StepDef extends SetUp {

    @Before
    public void initialization() {
        setUpEnvironment();
    }

    @After
    public void afterScenario() {
        tearDown();
    }

    @Given("user goes to registration page by opening Chrome")
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
        getScreenShot("1", role.replace("/", ""), new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("user press the Registration button")
    public void userPressTheRegistrationButton() {
        regPage.sentRegistrationData();
    }

    @Then("user with {string} should see successful notification on the Login page")
    public void userWithShouldSeeSuccessfulNotificationOnTheLoginPage(String role) {
        Assert.assertTrue(loginPage.justRegistered());
        getScreenShot("1", role.replace("/", ""), new Object() {
        }.getClass().getEnclosingMethod().getName().replace("With", " "));
    }

    @When("user enter Username in the Username field on the Login page")
    public void userEnterUsernameInTheUsernameFieldOnTheLoginPage() {
        loginPage.setUserName(generatedUserName);
    }

    @And("user enter {string} in the Password field on the Login page")
    public void userEnterInThePasswordFieldOnTheLoginPage(String pass) {
        loginPage.setPassword(pass);
    }

    @And("user with {string} press the Login button")
    public void userWithPressTheLoginButton(String role) {
        loginPage.goToStartPage();
        getScreenShot("1", role.replace("/", ""), new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Then("user should see the current Username on the Start page")
    public void userShouldSeeTheCurrentUsernameOnTheStartPage() {
        startPage.checkLogin(generatedUserName);
    }

    @Then("the user points the mouse on the hint in the {string} field AND see the {string}")
    public void theUserPointsTheMouseOnTheHintInTheFieldANDSeeThe(String field, String text) {
        String hintText = regPage.getTextFromElementByFieldName(field);
        getScreenShot("2", field, new Object() {
        }.getClass().getEnclosingMethod().getName());
        Assert.assertEquals(hintText, text);
    }

    @When("user fills Username without {string}")
    public void userFillsUsernameWithout(String symbol) {
        regPage.fillUserNameFieldWithoutParam(symbol);
        getScreenShot("3", "without" + symbol, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Then("user should see error {string} from the {string} field")
    public void userShouldSeeErrorFromTheField(String notification, String field) {
        String tcNumber = null;
        if (Objects.equals(field, "Password")) {
            tcNumber = "4";
        }
        if (Objects.equals(field, "Username")) {
            tcNumber = "3";
        }
        getScreenShot(tcNumber, notification, new Object() {
        }.getClass().getEnclosingMethod().getName());
        String errNote = regPage.getErrorMessageFromElementByFieldName(field);
        Assert.assertEquals(notification, errNote);
    }

    @When("user fills Password with {string}")
    public void userFillsPasswordWith(String pass) {
        regPage.setPassword(pass);
        getScreenShot("4", pass, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("click Registration button")
    public void clickRegistrationButton() {
        regPage.sentRegistrationData();
    }

    @Given("the user goes to login page by opening Chrome")
    public void theUserGoesToLoginPageByOpeningChrome() {
        loginPage
                .openLoginPage()
                .checkIsLoginPage();
    }

    @And("login with {string} and {string}")
    public void login(String username, String pass) {
        loginPage
                .setUserName(username)
                .setPassword(pass)
                .goToStartPage();
    }

    @Then("the user sees the Start page")
    public void theUserSeesTheStartPage() {
        startPage.checkThePageByTitle("Top");
    }

    @Given("the user is logged in as {string}")
    public void theUserIsLoggedInAs(String username) {
        startPage.checkLogin(username);
    }

    @When("the user points the mouse at Navigation and clicks the {string}")
    public void theUserPointsTheMouseAtNavigationAndClicksThe(String link) {
        getScreenShot("5", link, new Object() {
        }.getClass().getEnclosingMethod().getName());
        startPage.getLinkFromNavigationDropDown(link);
        getScreenShot("5", link, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Then("the user should see the current page {string} and {string}")
    public void theUserShouldSeeTheCurrentPageAnd(String pageTitle, String dispatcher) {
        startPage.checkThePageByTitle(pageTitle);
        Assert.assertTrue(startPage.checkThePageDispatcher(dispatcher));
    }
}
