package com.nc.edu.ta.doroshenkodenis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericSearchPage extends BasePage {
    public GenericSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchData(String data, String searchType) {
        writeText(By.xpath("//input[@id='search_form:name']"), data);
        setSearchType(searchType);
        click(By.xpath("//input[@type='submit']"));
    }

    public void setSearchType(String type) {
        driver.findElement(By.xpath("//select")).findElement(By.xpath("//select/option[text()='" + type + "']")).click();
    }

    public List<WebElement> getSearchResults(){
        return driver.findElements(By.xpath("//div[@id='table_data_search']//tbody//a"));
    }

}
