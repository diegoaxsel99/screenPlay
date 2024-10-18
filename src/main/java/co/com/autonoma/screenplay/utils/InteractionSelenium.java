package co.com.autonoma.screenplay.utils;

import co.com.autonoma.screenplay.repository.InteractionRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InteractionSelenium  implements InteractionRepository<By> {
    private WebDriverWait wait;
    private WebDriver driver;

    @Override
    public void clickButton(By Button){
        WebElement buttonWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Button));
        buttonWebElement.click();
    }

    @Override
    public <T> void fillField(By field, T data){
        WebElement nameInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        nameInputElement.sendKeys((CharSequence) data);
    }

    @Override
    public void alert(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public <T> void fillForm(T form, Map<String, By> fieldMappings) {
        try {

            for (Field field : form.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(form);

                By locator = fieldMappings.get(field.getName());

                if (locator != null && value != null) {
                    fillField(locator, value);
                } else if (locator == null) {
                    System.out.println("No locator found for field: " + field.getName());
                } else {
                    System.out.println("Null value for field: " + field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
