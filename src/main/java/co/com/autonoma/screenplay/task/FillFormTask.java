package co.com.autonoma.screenplay.task;

import co.com.autonoma.screenplay.utils.Actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FillFormTask<T> implements Task {

    private T form;

    private Map<String, By> fieldMappings;

    @Override
    public void performAs(Actor actor) {
        actor.getInteraction().fillForm(form, fieldMappings);
    }
}
