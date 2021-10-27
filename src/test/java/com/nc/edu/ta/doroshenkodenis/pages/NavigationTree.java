package com.nc.edu.ta.doroshenkodenis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationTree extends BasePage {

    public NavigationTree(WebDriver driver) {
        super(driver);
    }

    public void selectLocationBy(String country, String city, String building) {
        changeWindow();
        driver.findElement(By.xpath("//a[contains(text(),'Country: " + country + "')]//ancestor:: span/span[@class]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'City: " + city + "')]//ancestor:: span/span[@class]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Building: " + building + "')]")).click();
        click(By.xpath("//button[@id='OK']"));
    }

    public void selectNetElementBy(String country, String city, String building, String floor, String room, String elementName) {
        changeWindow();
        driver.findElement(By.xpath("//a[contains(text(),'Country: " + country + "')]//ancestor:: span/span[@class]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'City: " + city + "')]//ancestor:: span/span[@class]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Building: " + building + "')]//ancestor:: span/span[@class]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Floor: Floor#" + floor + "')]//ancestor:: span/span[@class]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Room: " + room + "')]//ancestor:: span/span[@class]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Rack: " + elementName + "')]")).click();
        click(By.xpath("//button[@id='OK']"));
    }
}
