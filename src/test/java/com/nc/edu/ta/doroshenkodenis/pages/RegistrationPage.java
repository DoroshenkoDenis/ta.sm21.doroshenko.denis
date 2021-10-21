package com.nc.edu.ta.doroshenkodenis.pages;

import com.nc.edu.ta.doroshenkodenis.helpers.DataGenerator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class RegistrationPage extends BasePage {
    String REG_URL = "https://inventory.edu-netcracker.com/pages/registration.xhtml";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage openRegPage() {
        driver.get(REG_URL);
        return this;
    }

    public RegistrationPage checkIsRegPage() {
        Assert.assertEquals(driver.getCurrentUrl(), REG_URL);
        return this;
    }

    public void setUserName(String userName) {
        writeText(By.id("registerForm:username"), userName);
    }

    public void setPassword(String password) {
        writeText(By.id("registerForm:password"), password);
        driver.findElement(By.id("registerForm:hide")).click();
    }

    public void setConfirmPassword(String password) {
        writeText(By.id("registerForm:confirmPassword"), password);
    }

    public void setEmail(String email) {
        writeText(By.id("registerForm:email"), email);
    }

    public void setRole(String role) {
        new Select(findElementById("registerForm:role")).selectByVisibleText(role);
    }

    public void sentRegistrationData() {
        click(By.name("registerForm:j_idt26"));
    }

    public String getTextFromElementByFieldName(String fieldName) {
        WebElement webElement = driver.findElement(By.xpath("//td[text() = '" + fieldName + "']/following-sibling:: td/label"));
        new Actions(driver).moveToElement(webElement).pause(3000).perform();
        return webElement.getAttribute("title");
    }

    public String getErrorMessageFromElementByFieldName(String fieldName) {
        return driver.findElement(By.xpath("//td[text() = '" + fieldName + "']/following-sibling:: td/span")).getText();
    }

    public void goToLoginPage() {
        driver.findElement(By.linkText("Login")).click();
    }

    public boolean getSentEmailNotification() {
        return Objects.equals(driver.findElement(By.cssSelector("[class=\"notification\"]")).getText(), "An email should have been sent to your address. It contains easy instructions to complete your registration");
    }


    public void fillUserNameFieldWithoutParam(String symbol) {
        if (Objects.equals(symbol, "digit")) {
            writeText(By.id("registerForm:username"), DataGenerator.getOnlyLetters(6));
        } else {
            if (Objects.equals(symbol, "letter")) {
                writeText(By.id("registerForm:username"), DataGenerator.getOnlyDigits(6));
            } else {
                writeText(By.id("registerForm:username"), DataGenerator.getRandomAlphanumeric(6));
            }
        }
    }

}
