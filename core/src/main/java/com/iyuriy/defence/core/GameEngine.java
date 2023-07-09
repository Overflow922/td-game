package com.iyuriy.defence.core;

import com.iyuriy.defence.events.GameEvent;

import java.util.Map;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class GameEngine implements Engine {

    private final Clock clock = new ClockImpl();
    private final ObjectManager objectManager = new GameObjectManager();
    private final NavigableMap<Long, GameEvent> gameEvents = new ConcurrentSkipListMap<>();
    private boolean isStopped;

    @Override
    public void start() {
        while (!isStopped) {
            long timestamp = clock.getTimestamp();
            var events = gameEvents.headMap(timestamp, true);
            for (var event: events.entrySet()) {
                System.out.println(event);
                event.getValue().processEvent(objectManager);
                handleNextExecution(event);
            }
            events.clear();
        }
    }

    private void handleNextExecution(Map.Entry<Long, GameEvent> pair) {
        GameEvent event = pair.getValue();
        if (!event.isPeriodicEvent())
            return;

        Long key = pair.getKey() + event.getNextEvent().toNanos();
        gameEvents.put(key, event);
    }

    @Override
    public void stop() {
        isStopped = true;
    }

    @Override
    public void addEvent(Long timestamp, GameEvent event) {
        gameEvents.put(timestamp, event);
    }
}
