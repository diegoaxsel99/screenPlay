package co.com.autonoma.screenplay.task;

import co.com.autonoma.screenplay.utils.Actor;

public class AlertTask<T> implements Task<T> {

    @Override
    public void performAs(Actor<T> actor) {
        actor.getInteraction().alert();
    }

    public static <T> AlertTask<T> alert() {
        return new AlertTask<>();
    }
}
