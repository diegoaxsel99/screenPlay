package co.com.autonoma.screenplay.task;

import co.com.autonoma.screenplay.utils.Actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClickButtonTask implements Task {

    private By buttonLocator;

    @Override
    public void performAs(Actor actor) {
        actor.getInteraction().clickButton(buttonLocator);
    }

    public static ClickButtonTask on(By buttonLocator) {
        return new ClickButtonTask(buttonLocator);
    }
}
