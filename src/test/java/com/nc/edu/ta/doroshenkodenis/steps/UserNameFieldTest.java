package com.nc.edu.ta.doroshenkodenis.steps;

import com.nc.edu.ta.doroshenkodenis.helpers.DataGenerator;
import com.nc.edu.ta.doroshenkodenis.pages.RegistrationPage;
import com.nc.edu.ta.doroshenkodenis.pages.SetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserNameFieldTest extends SetUp {

//    Тесты должны упасть требования R1.4 не реализованы

    @Before("@UsernameFieldTest")
    public void initialization() {
        setUpEnvironment();
    }

//    @BeforeStep("@RegTest")
//    public void beforeStep() {
//        takeScreenshot();
//    }

    @After("@UsernameFieldTest")
    public void afterScenario() {
        tearDown();
    }

    @Given("user goes to registration page by opening Chrome")
    public void userNavigatesToRegistrationPageByOpeningChrome() {
        regPage
                .openRegPage()
                .checkIsRegPage();
    }

    @When("user fills Username without {string}")
    public void userFillsUsernameWithout(String symbol) {
        regPage.fillUserNameFieldWithoutParam(symbol);
    }

    @Then("user should see error {string} from the {string} field")
    public void userShouldSeeErrorFromTheField(String notification, String field) {
        String errNote = regPage.getErrorMessageFromElementByFieldName(field);
        Assert.assertEquals(notification, errNote);
    }

// Method easy checking
//    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.openRegPage();
//        registrationPage.setUserName("=");
//        registrationPage.sentRegistrationData();
//        System.out.println(registrationPage.getErrorMessageFromElementByFieldName("Username"));
//        driver.close();
//    }
}
