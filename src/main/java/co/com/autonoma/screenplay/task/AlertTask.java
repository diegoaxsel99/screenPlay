package co.com.autonoma.screenplay.task;

import co.com.autonoma.screenplay.utils.Actor;

public class AlertTask implements Task {

    @Override
    public void performAs(Actor actor) {
        actor.getInteraction().alert();
    }
}
