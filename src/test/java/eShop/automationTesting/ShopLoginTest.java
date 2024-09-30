package eShop.automationTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testing.eShop.BasePage;
import org.testing.eShop.pagesObjects.HomePage;
import org.testing.eShop.pagesObjects.ShopHomePage;
import org.testing.eShop.pagesObjects.ShopLoginPage;
import org.testing.eShop.pagesObjects.ShopYourAccount;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ShopLoginTest extends BasePage {
    public ShopLoginTest() throws IOException {
    }
    @BeforeTest
    public void setUp() throws IOException {
        driver=getDriver();
        driver.get(getUrl());
    }
    @Test
    public void addRemoveItem() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.getToggle().click();
        homePage.getTestStoreLink().click();
        ShopHomePage shopHomePage = new ShopHomePage(driver);
        shopHomePage.getSignInButton().click();
        FileInputStream fileLocation = new
                FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\credentials.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileLocation);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row1 = sheet.getRow(1);
        Cell cellR1C0 = row1.getCell(0);
        Cell cellR1C1 = row1.getCell(1);

        String emailRow1 = cellR1C0.toString();
        String passwordRow1 = cellR1C1.toString();


        ShopLoginPage shop = new ShopLoginPage();
        shop.getEmail().sendKeys(emailRow1);
        shop.getPassword().sendKeys(passwordRow1);

        Thread.sleep(3000);

        shop.getSubmitBtn().click();

        ShopYourAccount yourAcc = new ShopYourAccount();
        yourAcc.getSignOutBtn().click();

        Row row2 = sheet.getRow(2);
        Cell cellR2C0 = row2.getCell(0);
        Cell cellR2C1 = row2.getCell(1);

        String emailRow2 = cellR2C0.toString();
        String passwordRow2 = cellR2C1.toString();

        shop.getEmail().sendKeys(emailRow2);
        shop.getPassword().sendKeys(passwordRow2);
        Thread.sleep(3000);
        shop.getSubmitBtn().click();
    }
}
