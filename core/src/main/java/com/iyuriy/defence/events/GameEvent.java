package com.iyuriy.defence.events;

import com.iyuriy.defence.core.ObjectManager;

import java.time.Duration;

public interface GameEvent {
    void processEvent(ObjectManager manager);

    default boolean isPeriodicEvent() {return false;}
    default Duration getNextEvent() {return Duration.ZERO;}
    
}
