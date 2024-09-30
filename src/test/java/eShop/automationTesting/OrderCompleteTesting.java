package eShop.automationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.eShop.BasePage;
import org.testing.eShop.pagesObjects.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class OrderCompleteTesting extends BasePage {

    public OrderCompleteTesting() throws IOException {
        super();
    }
    @BeforeTest
    public void setUp() throws IOException {
        driver=getDriver();
        driver.get(getUrl());
    }
    /*@AfterTest
    public void tearDown() {
        driver.quit();
        driver=null;
    }

     */
    @Test
    public void endToEndTest() throws IOException {
        HomePage homePage=new HomePage(driver);
        driver.findElement(By.cssSelector(".close-cookie-warning > span")).click();
        homePage.getToggle().click();
        WebElement element = driver.findElement(By.linkText("TEST STORE"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        ShopHomePage shopHomePage=new ShopHomePage(driver);
        shopHomePage.getProdOne().click();
        ShopProductPage shopProductPage=new ShopProductPage(driver);
        Select option=new Select(shopProductPage.getSizeOption());
        option.selectByVisibleText("M");
        shopProductPage.getQuantityIncrease().click();
        shopProductPage.getAddToCartButton().click();
        ShopContentPanel shopContentPanel=new ShopContentPanel(driver);
        shopContentPanel.getProceedToCheckOutButton().click();
        ShoppingCart shoppingCart=new ShoppingCart(driver);
        shoppingCart.getProceedCheckoutBtn().click();

        OrderFormPersInfo pInfo = new OrderFormPersInfo(driver);
        pInfo.getGenderMr().click();
        pInfo.getFirstNameField().sendKeys("John");
        pInfo.getLastnameField().sendKeys("Smith");
        pInfo.getEmailField().sendKeys("johnsmitho@test.com");
        pInfo.getTermsConditionsCheckbox().click();
        pInfo.getContinueBtn().click();

        // creating an object of the order delivery info page
        OrderFormDelivery orderDelivery = new OrderFormDelivery(driver);
        orderDelivery.getAddressField().sendKeys("123 Main Street");
        orderDelivery.getPostcodeField().sendKeys("12345");
        orderDelivery.getCityField().sendKeys("Houston");
        Select state = new Select(orderDelivery.getStateDropdown());
        state.selectByVisibleText("France");
        orderDelivery.getPhoneField().sendKeys("0611752676");
        orderDelivery.getContinueBtn().click();





        // creating an object of the shipping method page
        OrderFormShippingMethod shipMethod = new OrderFormShippingMethod(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deliveryMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea#delivery_message")));
        deliveryMessage.sendKeys("If I am not in, please leave my delivery on my porch.");
        shipMethod.getContinueBtn().click();

    }
}
