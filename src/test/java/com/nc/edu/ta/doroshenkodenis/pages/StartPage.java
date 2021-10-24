package com.nc.edu.ta.doroshenkodenis.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void checkLogin(String userName) {
        isElementDisplayed(By.xpath("//*[@class='logout']"));
        Assert.assertEquals(userName, driver.findElement(By.xpath("//tbody/tr/td[3]")).getText());
    }

    public void checkThePageByTitle(String headTitle) {
        String elementText = driver.getTitle();
        Assert.assertEquals(elementText, headTitle);
    }

    public void openLinkFromNavigationDropDown(String link) {
        driver.findElement(By.xpath("//a[text() = '" + link + "']")).click();
    }

    public boolean checkThePageDispatcher(String dispatcher) {
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='path']/a"));
        StringBuilder stringBuilder = new StringBuilder();
        for (WebElement element : list) {
            stringBuilder.append(element.getText()).append(" > ");
        }
        return stringBuilder.toString().contains(dispatcher);
    }

    public void showNavigationDropdown() {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Navigation')]"));
        new Actions(driver).moveToElement(element).pause(500).perform();
    }
}
