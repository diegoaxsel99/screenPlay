package co.com.autonoma.screenplay.task;

import co.com.autonoma.screenplay.utils.Actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FillFieldTask<T> implements Task {

    private By fieldLocator;

    private T data;

    @Override
    public void performAs(Actor actor) {
        actor.getInteraction().fillField(fieldLocator, data);
    }
}
