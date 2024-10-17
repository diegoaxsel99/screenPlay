package co.com.autonoma.screenplay;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



    }


}
