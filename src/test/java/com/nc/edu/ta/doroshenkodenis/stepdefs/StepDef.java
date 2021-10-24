package com.nc.edu.ta.doroshenkodenis.stepdefs;

import com.nc.edu.ta.doroshenkodenis.helpers.DataGenerator;
import com.nc.edu.ta.doroshenkodenis.pages.SetUp;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.ListIterator;
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
    public void openRegPage() {
        regPage
                .openRegPage()
                .checkIsRegPage();
    }

    String generatedUserName;

    @When("user enter {string} in the Username field")
    public void fillUsername(String username) {
        generatedUserName = username + DataGenerator.getRandomAlphanumeric(6);
        regPage.setUserName(generatedUserName);
    }

    @And("user enter {string} in the Password field")
    public void fillPassword(String pass) {
        regPage.setPassword(pass);
    }

    @And("user enter {string} in the Repeat Password field")
    public void confirmPassword(String repeatedPass) {
        regPage.setConfirmPassword(repeatedPass);
    }

    @And("user enter {string} in the Email field")
    public void fillEmail(String email) {
        regPage.setEmail(generatedUserName + email);
    }

    @And("user select {string} from Role dropdown")
    public void selectRole(String role) {
        regPage.setRole(role);
        getScreenShot("1", role.replace("/", ""), new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("user press the Registration button")
    public void sentRegData() {
        regPage.sentRegistrationData();
    }

    @Then("user with {string} should see successful notification on the Login page")
    public void userWithShouldSeeSuccessfulNotificationOnTheLoginPage(String role) {
        Assert.assertTrue(loginPage.justRegistered());
        getScreenShot("1", role.replace("/", ""), new Object() {
        }.getClass().getEnclosingMethod().getName().replace("With", " "));
    }

    @When("user enter Username in the Username field on the Login page")
    public void fillRegisteredUsername() {
        loginPage.setUserName(generatedUserName);
    }

    @And("user enter {string} in the Password field on the Login page")
    public void fillRegisteredPassword(String pass) {
        loginPage.setPassword(pass);
    }

    @And("user with {string} press the Login button")
    public void sentLoginData(String role) {
        loginPage.goToStartPage();
        getScreenShot("1", role.replace("/", ""), new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Then("user should see the current Username on the Start page")
    public void checkUsernameOnStartPage() {
        startPage.checkLogin(generatedUserName);
    }

    @Then("the user points the mouse on the hint in the {string} field and see the {string}")
    public void checkHint(String field, String text) {
        String hintText = regPage.getTextFromElementByFieldName(field);
        getScreenShot("2", field.replace(":", ""), new Object() {
        }.getClass().getEnclosingMethod().getName());
        Assert.assertEquals(hintText, text);
    }

    @When("user fills Username without {string}")
    public void fillUsernameWithoutSymbol(String symbol) {
        regPage.fillUserNameFieldWithoutParam(symbol);
        getScreenShot("3", "without" + symbol, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Then("user should see error {string} from the {string} field")
    public void checkUsernameFieldError(String notification, String field) {
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
    public void fillTestPassword(String pass) {
        regPage.setPassword(pass);
        getScreenShot("4", pass, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Given("the user goes to login page by opening Chrome")
    public void openLoginPage() {
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
    public void checkTheStartPage() {
        startPage.checkThePageByTitle("Top");
    }

    @Given("the user is logged in as {string}")
    public void theUserIsLoggedInAs(String username) {
        startPage.checkLogin(username);
    }

    @When("the user points the mouse at {string}")
    public void pointNavigationDropdown(String dropdown) {
        startPage.showNavigationDropdown();
        getScreenShot("5", dropdown, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("clicks the {string}")
    public void clickTheLink(String link) {
        startPage.openLinkFromNavigationDropDown(link);
        getScreenShot("5", link, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Then("the user should see the current page {string} and {string}")
    public void checkPageByTitle(String pageTitle, String dispatcher) {
        startPage.checkThePageByTitle(pageTitle);
        Assert.assertTrue(startPage.checkThePageDispatcher(dispatcher));
    }

    @And("select {string} Tab")
    public void selectTab(String tabName) {
        inventoryPage.selectTabByName(tabName);
    }

    @And("remove {string} if exists")
    public void removeObjIfExists(String obj) {
        inventoryPage.removeObject(obj);
    }

    @And("creates by {string} button {string} with {string} continent and {string} language")
    public void createCountry(String btn, String country, String continent, String language) {
        inventoryPage
                .createCountry(btn, country, continent, language)
                .saveCreatedObject();
        getScreenShot("5", country, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("creates by {string} button the {string} city with {string} population and regional status {string}")
    public void createCity(String btn, String city, String population, String status) {
        inventoryPage
                .createCity(btn, city, population, status)
                .saveCreatedObject();
        getScreenShot("5", city, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("creates by {string} button the {string} with street {string}, build number {string}, Square {string} and Connection status {string}")
    public void createBuilding(String btn, String buildingName, String street, String buildingNumber, String square, String connStatus) {
        inventoryPage
                .createBuilding(btn, buildingName, street, buildingNumber, square, connStatus)
                .saveCreatedObject();
        getScreenShot("5", buildingName, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("creates by {string} button the {string} floor with {string} square")
    public void createFloor(String btn, String floor, String square) {
        inventoryPage
                .createFloor(btn, floor, square)
                .saveCreatedObject();
        getScreenShot("5", "floor#" + floor, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("creates by {string} button the {string} room with {string} square")
    public void createRoom(String btn, String roomName, String square) {
        inventoryPage
                .createRoom(btn, roomName, square)
                .saveCreatedObject();
        getScreenShot("5", roomName, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("creates by {string} button the {string} rack with width: {string}, length: {string}, height: {string}, {string} physical status")
    public void createRack(String btn, String rackName, String width, String length, String height, String status) {
        inventoryPage
                .createRack(btn, rackName, width, length, height, status)
                .saveCreatedObject();
        getScreenShot("5", rackName, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @And("creates by {string} button the {string} device with {string} MAC Address, {string} Gb RAM, {string} CPU, {string} IP Address," +
            " {string} physical status, width: {string}, length: {string}, height: {string}, Located in {string} {string} {string}," +
            " Network Element:  {string} floor, {string} room, {string} network element")
    public void createDevice(String btn, String deviceName, String mac, String ram, String cpu, String ip, String status, String width, String length,
                             String height, String country, String city, String building, String floor, String room, String elementName) {
        inventoryPage
                .createDevice(btn, deviceName, mac, ram, cpu, ip, status, length, width, height, country, city, building, floor, room, elementName)
                .saveCreatedObject();
        getScreenShot("5", deviceName, new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @When("the user click Search... field and press Enter")
    public void openSearchPage() {
        inventoryPage.openSearchPage();
    }

    @And("fill field with search {string}, select {string} and press Enter")
    public void searchData(String data, String searchType) {
        searchPage.searchData(data, searchType);
    }

    @Then("the user should see result {string}")
    public void theUserShouldSeeResult(String obj) {
        ListIterator<WebElement> list = searchPage.getSearchResults().listIterator();
        boolean check = false;
        while (list.hasNext()) {
            WebElement temp = list.next();
            String text = temp.getText();
            if (text.equals(obj)) {
                check = true;
            }
        }
        Assert.assertTrue(check);
    }

}
