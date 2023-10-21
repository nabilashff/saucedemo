package cucumbers.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class addToCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("Login page Sauce Demo - Add To Cart")
    public void login_page_sauce_demo_add_to_cart(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertions
        String loginLogo = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginLogo,"Swag Labs");
    }

    @When("Input user-name - Add To Cart")
    public void inputUserName() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password - Add to Cart")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click the login button - Add to Cart")
    public void clickTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User redirected to dashboard page")
    public void userRedirectedToDashboardPage() {
        String itemExist = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(itemExist,"Sauce Labs Backpack");
    }

    @Then("Add Bag to Cart")
    public void addBagToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String itemExist = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(itemExist,"Sauce Labs Backpack");
    }

}
