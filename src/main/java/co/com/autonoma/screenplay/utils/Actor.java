package co.com.autonoma.screenplay.utils;

import co.com.autonoma.screenplay.repository.InteractionRepository;
import co.com.autonoma.screenplay.task.Task;
import lombok.*;
import org.openqa.selenium.WebDriver;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Actor<T> {

    private String name;
    private WebDriver driver;
    private InteractionRepository<T> interaction;

    public <E extends Task<T>> void attemptsTo(E task) {
        task.performAs(this);
    }
}
