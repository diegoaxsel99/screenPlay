package co.com.autonoma.screenplay.utils;

import co.com.autonoma.screenplay.task.Task;
import lombok.*;
import org.openqa.selenium.WebDriver;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    private String name;
    private WebDriver driver;
    private InteractionSelenium interaction;

    public <T extends Task> void attemptsTo(T task) {
        task.performAs(this);
    }
}
