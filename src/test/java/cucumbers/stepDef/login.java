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

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("Login page Sauce Demo")
    public void login_page_sauce_demo(){
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

    @When("Input user-name")
    public void inputUserName() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click the login button")
    public void clickTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User redirected to dashboard Page")
    public void userRedirectedToDashboardPage() {
        String itemExist = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(itemExist,"Sauce Labs Backpack");
    }

    @And("Input invalid user-name")
    public void inputInvalidUserName() {
        driver.findElement(By.id("user-name")).sendKeys("salah_user");
    }


    @Then("user get error button")
    public void userGetErrorButton() {
        String xPath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";

        String errorMessage = driver.findElement(By.xpath(xPath)).getText();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
