import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test //Tag Untuk Running
    public void success_login(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);

        //Membuka Halaman Login
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String loginLogo = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginLogo,"Swag Labs");
        //Input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click Login
        driver.findElement(By.id("login-button")).click();

        String itemExist = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(itemExist,"Sauce Labs Backpack");
        driver.close();

    }

    @Test
    public void failed_login(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);

        //Membuka Halaman Login
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Input username
        driver.findElement(By.id("user-name")).sendKeys("salah_user");
        //Input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click Login
        driver.findElement(By.id("login-button")).click();

        String xPath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";

        String errorMessage = driver.findElement(By.xpath(xPath)).getText();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");

        driver.close();
    }
}
