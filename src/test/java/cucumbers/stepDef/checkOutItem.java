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

public class checkOutItem {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("Login page Sauce Demo - CheckOut Item")
    public void login_page_sauce_demo_checkOut_item(){
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

    @When("Input user-name - CheckOut Item")
    public void inputUserNameCheckOutItem() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password - CheckOut Item")
    public void inputPasswordCheckOutItem() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click the login button - CheckOut Item")
    public void clickTheLoginButtonCheckOutItem() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User redirected to dashboard page - CheckOut Item")
    public void userRedirectedToDashboardPageCheckOutItem() {
        String itemExist = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(itemExist,"Sauce Labs Backpack");
    }

    @And("Add items to Cart")
    public void addItemsToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("Click cart button")
    public void clickCartButton() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("Click checkout button")
    public void clickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("Input first-name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Nabila");
    }

    @And("Input last-name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Test");
    }

    @And("Input zipCode")
    public void inputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("123456");
    }

    @And("Click continue button")
    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("Click finish button")
    public void clickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("redirect to successfully checkout page")
    public void redirectToSuccessfullyCheckoutPage() {
        String xPath = "//*[@id=\"checkout_complete_container\"]/h2";

        String totalItem = driver.findElement(By.xpath(xPath)).getText();
        Assert.assertEquals(totalItem,"Thank you for your order!");
    }
}
