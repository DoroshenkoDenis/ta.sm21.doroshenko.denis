package com.nc.edu.ta.doroshenkodenis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericSearchPage extends BasePage {
    public GenericSearchPage(WebDriver driver) {
        super(driver);
    }

    public void writeTextByFieldName(String fieldName, String data) {
        writeText(By.xpath("//th[text()='" + fieldName + "']/following::input"), data);
    }

    public GenericSearchPage searchData(String data, String searchType, String fieldName) {
        writeTextByFieldName(fieldName, data);
        setSearchType(fieldName, searchType);
        return this;
    }

    public void searchClick() {
        click(By.xpath("//input[@type='submit']"));
    }

    public void setSearchType(String fieldName, String type) {
        driver.findElement(By.xpath("//th[contains(text(),'" + fieldName + "')]/following::select/option[text()='" + type + "']")).click();

    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.xpath("//div[@id='table_data_search']//tbody//a"));
    }

    public void findCountry(String countryName, String lang, String type1, String name, String type2, String continent, String type3, String language) {
        writeTextByFieldName(name, countryName);
        setSearchType(name, type1);
        setSearchType(continent, type2);
        writeTextByFieldName(language, lang);
        setSearchType(language, type3);
        searchClick();
    }


    public void findCity(String cityName, String popNumber, String type1, String name, String type2, String population, String type3, String isCenter) {
        writeTextByFieldName(name, cityName);
        setSearchType(name, type1);
        writeTextByFieldName(population, popNumber);
        setSearchType(population, type2);
        setSearchType(isCenter, type3);
        searchClick();
    }

    public void findBuilding(String buildingName, String streetName, String type1, String name, String type2, String street, String type3, String isConn) {
//      можно добавить выборку по номеру и площади
        writeTextByFieldName(name, buildingName);
        setSearchType(name, type1);
        writeTextByFieldName(street, streetName);
        setSearchType(street, type2);
        setSearchType(isConn, type3);
        searchClick();
    }

    public void clickSearchResult() {
        click(By.xpath("//div[@id='table_data_search']//tbody//a"));
    }

    public void searchBySearchField(String obj) {
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder=' Search...']"));
        searchField.click();
        searchField.sendKeys(obj, Keys.ENTER);
    }

    public String getEmptyMessage() {
        return driver.findElement(By.xpath("//div[@id='table_data_search']//tr[@class='ui-widget-content ui-datatable-empty-message']//td")).getText();
    }
}
