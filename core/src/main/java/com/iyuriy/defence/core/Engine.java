package com.iyuriy.defence.core;

import com.iyuriy.defence.events.GameEvent;

public interface Engine {

    void start();

    void stop();

    void addEvent(Long timestamp, GameEvent event);
}
