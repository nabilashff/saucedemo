import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddItemToCart {
    @Test
    public void addItem(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);

        //Open Login Page
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click Login
        driver.findElement(By.id("login-button")).click();

        //After Login, redirect to dashboard
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String xPath = "//*[@id=\"shopping_cart_container\"]/a";

        String totalItem = driver.findElement(By.xpath(xPath)).getText();
        Assert.assertEquals(totalItem,"1");

    }
}
