package com.nc.edu.ta.doroshenkodenis.pages;

import com.nc.edu.ta.doroshenkodenis.helpers.Screenshot;
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
    int i = 1;

    public void setUpEnvironment() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1100, 500));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        regPage = PageFactory.initElements(driver, RegistrationPage.class);
        startPage = PageFactory.initElements(driver, StartPage.class);
    }

    public void tearDown() {
        driver.quit();
    }

    public void getScreenShot(String tcNumber, String testName, String stepName) {
        try{
            Screenshot.takeSnapShot(driver, "scrShot/TC " + tcNumber + "/" + i + " " + testName + "_" + stepName + ".png");
            i++;
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}
