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
public class FillFieldTask<T> implements Task<T> {

    private T fieldLocator;
    private String data;

    @Override
    public void performAs(Actor<T> actor) {
        actor.getInteraction().fillField(fieldLocator, data);
    }

    public static <T> FillFieldTask<T> with(T fieldLocator, String data) {
        return new FillFieldTask<>(fieldLocator, data);
    }
}
