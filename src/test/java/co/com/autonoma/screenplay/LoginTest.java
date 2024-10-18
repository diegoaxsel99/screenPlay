package co.com.autonoma.screenplay;

import co.com.autonoma.screenplay.task.ClickButtonTask;
import co.com.autonoma.screenplay.utils.Actor;
import co.com.autonoma.screenplay.utils.InteractionSelenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actor actor;

    @BeforeTest
    public void setup() {


        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actor = Actor.builder()
                .name("User")
                .driver(driver)
                .interaction(new InteractionSelenium(wait, driver))
                .build();


    }

    @Test
    public void login() throws InterruptedException {
        Thread.sleep(1000);
        actor.attemptsTo(ClickButtonTask.on(By.id("login2")));
        Thread.sleep(1000);
    }

    @AfterTest
    public void teardown() {
        if (driver != null){
            driver.quit();
        }
    }


}
