package com.nc.edu.ta.doroshenkodenis.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    String LOGIN_URL = "https://inventory.edu-netcracker.com/login.jsp";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        driver.get(LOGIN_URL);
        return this;
    }

    public boolean justRegistered() {
        return driver.findElement(By.className("justRegisteredBlock")).isEnabled();
    }

    public LoginPage checkIsLoginPage() {
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_URL);
        return this;
    }

    public void goToRegistrationPage() {
        click(By.xpath("//tbody//*[text()='Registration']"));
    }


    public LoginPage setUserName(String userName) {
        writeText(By.xpath("//tbody//*[@name='j_username']"), userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        writeText(By.xpath("//tbody//*[@name='j_password']"), password);
        return this;
    }

    public void goToStartPage() {
        click(By.xpath("//tbody//*[@value='Login']"));
    }

}
