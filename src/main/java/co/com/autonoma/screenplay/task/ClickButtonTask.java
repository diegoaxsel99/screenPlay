package co.com.autonoma.screenplay.task;

import co.com.autonoma.screenplay.repository.InteractionRepository;
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
public class ClickButtonTask<T> implements Task<T> {

    private T buttonLocator;
    private InteractionRepository<T> interaction;

    @Override
    public void performAs(Actor<T> actor) {
        actor.getInteraction().clickButton(buttonLocator);
    }

    public static <T> ClickButtonTask<T> on(T buttonLocator, InteractionRepository<T> interaction) {
        return new ClickButtonTask<>(buttonLocator, interaction);
    }
}
