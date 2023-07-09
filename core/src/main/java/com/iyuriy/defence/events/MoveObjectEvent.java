package com.iyuriy.defence.events;

import com.iyuriy.defence.core.GameObject;
import com.iyuriy.defence.core.ObjectManager;
import com.iyuriy.defence.core.Vec2;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MoveObjectEvent implements GameEvent {
    private final GameObject object;

    public MoveObjectEvent(GameObject object) {
        this.object = object;
    }

    @Override
    public void processEvent(ObjectManager manager) {
        object.move(1, 1);
    }

    @Override
    public boolean isPeriodicEvent() {
        return true;
    }

    @Override
    public Duration getNextEvent() {
        return Duration.of(500, ChronoUnit.MILLIS);
    }
}
