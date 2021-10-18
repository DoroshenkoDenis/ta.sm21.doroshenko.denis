package com.nc.edu.ta.doroshenkodenis.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SetUp {
    public WebDriver driver;
    public RegistrationPage regPage;
    public LoginPage loginPage;
    public StartPage startPage;

    public void setUpEnvironment() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200,500));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        regPage = PageFactory.initElements(driver,RegistrationPage.class);
        startPage = PageFactory.initElements(driver,StartPage.class);
    }

    public void tearDown() {
        driver.quit();
    }

//    @Rule
//    public TestName testName = new TestName();
//
//    public void setDataFull(String userName, String password, String confirmPassword, String email, String role, String testCaseNumber) throws Exception {
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.setUserName(userName);
//        registrationPage.setPassword(password);
//        registrationPage.setRepeatPassword(confirmPassword);
//        registrationPage.setUnmaskPassword();
//        registrationPage.setEmail(email);
//        registrationPage.setRole(role);
//        Screenshot.takeSnapShot(driver, "scrShot/TC" + testCaseNumber + "/" + testName.getMethodName() + "_step1.png");
//        registrationPage.sentRegistrationData();
//        Thread.sleep(2000);
//        Screenshot.takeSnapShot(driver, "scrShot/TC" + testCaseNumber + "/" + testName.getMethodName() + "_step2.png");
//    }
//
//    public void setData(String userName, String password, String email, String role) {
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.openPage("https://inventory.edu-netcracker.com/pages/registration.xhtml");
//        registrationPage.setUserName(userName);
//        registrationPage.setPassword(password);
//        registrationPage.setRepeatPassword(password);
//        registrationPage.setUnmaskPassword();
//        registrationPage.setEmail(email);
//        registrationPage.setRole(role);
//    }
}
