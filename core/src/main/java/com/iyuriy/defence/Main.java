package com.iyuriy.defence;

import com.iyuriy.defence.core.ClockImpl;
import com.iyuriy.defence.core.GameEngine;
import com.iyuriy.defence.core.PlayerObject;
import com.iyuriy.defence.core.Vec2;
import com.iyuriy.defence.events.AddObjectEvent;
import com.iyuriy.defence.events.MoveObjectEvent;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        ClockImpl clock = new ClockImpl();
        GameEngine engine = new GameEngine();
        PlayerObject player = new PlayerObject(new Vec2(1.0, 1.2));
        AddObjectEvent playerEvent = new AddObjectEvent(player);
        engine.addEvent(clock.getTimestampIn(Duration.ofSeconds(2)), playerEvent);
        System.out.println("started");
        MoveObjectEvent moveObjectEvent = new MoveObjectEvent(player);
        engine.addEvent(clock.getTimestampIn(Duration.ofSeconds(2)), moveObjectEvent);
        engine.start();
    }
}