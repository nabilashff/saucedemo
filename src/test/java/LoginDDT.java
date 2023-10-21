import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginDDT {
    //Login With Data Drive Test
    @Test
    public void login_ddt(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);

        //Membuka Halaman Login
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        String csvDir = System.getProperty("user.dir")+"src\\test\\data";
    }
}
