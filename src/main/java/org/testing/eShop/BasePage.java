package org.testing.eShop;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
    public static WebDriver driver;
    private String url;
    private Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
        prop.load(data);
    }

    public WebDriver getDriver() throws IOException {
        if (prop.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public String getUrl() throws IOException {
        url = prop.getProperty("url");
        return url;
    }

   /*
     public void takeSnapShot(WebDriver webdriver) throws IOException {
        File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir") + "\\target\\screenshots\\"
                + timestamp() + ".png");

        FileUtils.copyFile(srcFile, destFile);
    }
    */

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
