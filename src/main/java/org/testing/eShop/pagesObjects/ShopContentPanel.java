package org.testing.eShop.pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopContentPanel {
    public WebDriver driver;
    By continueShoppingButton=By.xpath("//button[contains(text(),'Continue')]");
    By proceedToCheckOutButton=By.cssSelector(".modal-body .btn.btn-primary");

    public WebElement getContinueShoppingButton() {
        return driver.findElement(continueShoppingButton);
    }
    public WebElement getProceedToCheckOutButton() {
        return driver.findElement(proceedToCheckOutButton);
    }
    public ShopContentPanel(WebDriver driver) {
        this.driver = driver;
    }
}
