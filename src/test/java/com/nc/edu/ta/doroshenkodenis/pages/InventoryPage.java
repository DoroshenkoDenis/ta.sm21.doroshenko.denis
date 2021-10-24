package com.nc.edu.ta.doroshenkodenis.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage selectTabByName(String tabName) {
        driver.findElement(By.xpath("//ul[@role='tablist']/li/a[text()='" + tabName + "']")).click();
        return this;
    }

    public void fillByFieldName(String fieldName, String value) {
        driver.findElement(By.xpath("//div[@id='table_data']//tr/th[text()='" + fieldName + "']//following-sibling:: td/input")).sendKeys(value);
    }

    public void selectInvPageElementByText(String text) {
        WebElement continentDropDown = driver.findElement(By.xpath("//select"));
        new Select(continentDropDown).selectByVisibleText(text);
    }

    public InventoryPage createCountry(String btn, String country, String continent, String language) {
        getCreatingTab(btn);
        fillByFieldName("Name", country);
        selectInvPageElementByText(continent);
        fillByFieldName("Language", language);
        return this;
    }

    public InventoryPage createCity(String btn, String city, String population, String status) {
        getCreatingTab(btn);
        fillByFieldName("Name", city);
        fillByFieldName("Population", population);
        selectInvPageElementByText(status);
        return this;
    }

    public void saveCreatedObject() {
        click(By.xpath("//input[@value='Save']"));
    }

    public void removeObject(String objName) {
        try {
            driver.findElement(By.xpath("//a[contains(text(),'" + objName + "')]/preceding-sibling:: input[@type='checkbox']")).click();
            click(By.xpath("//input[@value='Delete']"));
        } catch (NoSuchElementException ignored) {
        }
    }

    public InventoryPage createBuilding(String btn, String buildingName, String street, String buildingNumber, String square, String connStatus) {
        getCreatingTab(btn);
        fillByFieldName("Name", buildingName);
        fillByFieldName("Street Name", street);
        fillByFieldName("Number", buildingNumber);
        fillByFieldName("Square", square);
        selectInvPageElementByText(connStatus);
        return this;
    }

    private void getCreatingTab(String btn) {
        click(By.xpath("//a[contains(text(),'" + btn + "')]"));
    }

    public InventoryPage createFloor(String btn, String floor, String square) {
        getCreatingTab(btn);
        fillByFieldName("Number", floor);
        fillByFieldName("Square", square);
        return this;
    }

    public InventoryPage createRoom(String btn, String roomName, String square) {
        getCreatingTab(btn);
        fillByFieldName("Name", roomName);
        fillByFieldName("Square", square);
        return this;
    }

    public InventoryPage createRack(String btn, String rackName, String width, String length, String height, String status) {
        getCreatingTab(btn);
        fillByFieldName("Name", rackName);
        fillByFieldName("Width", width);
        fillByFieldName("Length", length);
        fillByFieldName("Height", height);
        selectInvPageElementByText(status);
        return this;
    }

    public InventoryPage createDevice(String btn, String deviceName, String mac, String ram, String cpu, String ip, String status, String width, String length, String height, String locCountry, String locCity, String locBuilding, String locFloor, String locRoom, String elementName) {
        NavigationTree navigationTree = new NavigationTree(driver);
        String winHandleBefore = driver.getWindowHandle();
        getCreatingTab(btn);
        fillByFieldName("Name", deviceName);
        fillByFieldName("MAC Address", mac);
        fillByFieldName("RAM(Gb)", ram);
        fillByFieldName("CPU", cpu);
        fillByFieldName("IP Address", ip);
        selectInvPageElementByText(status);
        fillByFieldName("Width", width);
        fillByFieldName("Length", length);
        fillByFieldName("Height", height);
        openNavigationTreeByFieldName("Located in");
        navigationTree.selectLocationBy(locCountry, locCity, locBuilding);
        driver.switchTo().window(winHandleBefore);
        openNavigationTreeByFieldName("Network Element");
        navigationTree.selectNetElementBy(locCountry, locCity, locBuilding, locFloor, locRoom, elementName);
        driver.switchTo().window(winHandleBefore);
        return this;
    }


    public void openNavigationTreeByFieldName(String fieldName) {
        driver.findElement(By.xpath("//div[@id='table_data']//tr/th[text()='" + fieldName + "']//following-sibling:: td/a")).click();
    }

    public GenericSearchPage openSearchPage() {
        driver.findElement(By.xpath("//input[@id='search-text-input']")).sendKeys(Keys.ENTER);
        return new GenericSearchPage(driver);
    }
}
