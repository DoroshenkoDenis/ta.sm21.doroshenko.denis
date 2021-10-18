package com.nc.edu.ta.doroshenkodenis.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void checkLogin(String userName){
        isElementDisplayed(By.xpath("//*[@class='logout']"));
        Assert.assertEquals(userName, driver.findElement(By.xpath("//tbody/tr/td[3]")).getText());
    }
}
