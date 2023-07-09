package com.iyuriy.defence.events;

import com.iyuriy.defence.core.GameObject;
import com.iyuriy.defence.core.ObjectManager;
import com.iyuriy.defence.core.Vec2;
import com.iyuriy.defence.core.math.MathUtils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MoveObjectEvent implements GameEvent {
    private final GameObject object;
    private final Vec2 endPos;
    private final Vec2 speedVec;
    private final double speed;
    private boolean shouldRepeat = true;

    public MoveObjectEvent(GameObject object, Vec2 endPos, double speed) {
        this.object = object;
        this.endPos = endPos;
        this.speed = speed;
        this.speedVec = MathUtils.getDelta(object.getCoords(), endPos, speed);
    }

    @Override
    public void processEvent(ObjectManager manager) {
        Vec2 coords = object.getCoords();
        Vec2 tmp = endPos.minus(coords);
        double len = tmp.getLength();
        if (len < speed) {
            object.setCoords(endPos);
            shouldRepeat = false;
        } else {
        object.move(speedVec);
        }
        System.out.println(object);
    }

    @Override
    public boolean isPeriodicEvent() {
        return shouldRepeat;
    }

    @Override
    public Duration getNextEvent() {
        return Duration.of(500, ChronoUnit.MILLIS);
    }
}
