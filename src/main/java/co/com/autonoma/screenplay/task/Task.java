package co.com.autonoma.screenplay.task;

import co.com.autonoma.screenplay.utils.Actor;

public interface Task<T> {
    void performAs(Actor<T> actor);
}
