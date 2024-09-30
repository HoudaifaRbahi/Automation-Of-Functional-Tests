package org.testing.eShop.pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopProductPage {
    public WebDriver driver;

    By sizeOption=By.cssSelector("select[name='group[1]']");
    By quantityIncrease=By.cssSelector(".touchspin-up");
    By quantityDecrease=By.cssSelector(".touchspin-down");
    By addToCartButton=By.cssSelector(".add-to-cart.btn.btn-primary");
    By homeLink=By.xpath("//span[.='Home']");
    public ShopProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSizeOption() {
        return driver.findElement(sizeOption);
    }
    public WebElement getQuantityIncrease() {
        return driver.findElement(quantityIncrease);
    }
    public WebElement getQuantityDecrease() {
        return driver.findElement(quantityDecrease);
    }
    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButton);
    }
    public WebElement getHomeLink() {
        return driver.findElement(homeLink);
    }
}
