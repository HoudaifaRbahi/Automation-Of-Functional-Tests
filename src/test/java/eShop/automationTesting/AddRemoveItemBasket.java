package eShop.automationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.eShop.BasePage;
import org.testing.eShop.pagesObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AddRemoveItemBasket extends BasePage {
    public AddRemoveItemBasket() throws IOException {
        super();
        // TODO Auto-generated constructor stub
    }

    @BeforeTest
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }


    @Test
    public void addRemoveItem() throws IOException, InterruptedException {
        // creating an object of the automationtesting.co.uk webpage
        HomePage home = new HomePage(driver);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        home.getToggle().click();
        jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink());
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        ShopHomePage shopHome = new ShopHomePage(driver);
        shopHome.getProdOne().click();

        // creating an object of the shop products page (when a product has been selected)
        ShopProductPage shopProd = new ShopProductPage(driver);
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantityIncrease().click();
        shopProd.getAddToCartButton().click();

        // creating an object of the cart content panel (once an item was added)
        ShopContentPanel cPanel = new ShopContentPanel(driver);
        cPanel.getContinueShoppingButton().click();
        shopProd.getHomeLink().click();
        shopHome.getProdTwo().click();
        shopProd.getAddToCartButton().click();
        cPanel.getProceedToCheckOutButton().click();

        ShoppingCart cart = new ShoppingCart(driver);
        cart.getDeleteItemTwo().click();

      Thread.sleep(5000);
       // wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));

        Assert.assertEquals(cart.getTotalAmount(),45.25);

    }
}
