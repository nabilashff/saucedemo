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

public class removeFromCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("Login page Sauce Demo - Remove To Cart")
    public void login_page_sauce_demo_remove_to_cart(){
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

    @When("Input user-name - Remove To Cart")
    public void inputUserNameRemoveToCart() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password - Remove to Cart")
    public void inputPasswordRemoveToCart() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click the login button - Remove to Cart")
    public void clickTheLoginButtonRemoveToCart() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User redirected to dashboard page - Remove to Cart")
    public void userRedirectedToDashboardPageRemoveToCart() {
        String itemExist = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(itemExist,"Sauce Labs Backpack");
    }

    @And("Add item to Cart")
    public void addItemToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @Then("Remove one item from cart")
    public void removeOneItemFromCart() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        String xPath = "//*[@id=\"shopping_cart_container\"]/a";

        String totalItem = driver.findElement(By.xpath(xPath)).getText();
        Assert.assertEquals(totalItem,"1");
    }
}
