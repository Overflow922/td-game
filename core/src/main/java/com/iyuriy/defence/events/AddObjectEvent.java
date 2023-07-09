package com.iyuriy.defence.events;

import com.iyuriy.defence.core.GameObject;
import com.iyuriy.defence.core.ObjectManager;

import java.util.Arrays;
import java.util.List;

public class AddObjectEvent implements GameEvent {
    private final List<GameObject> list;

    public AddObjectEvent(GameObject... objects) {
        this.list = Arrays.asList(objects);
    }

    @Override
    public void processEvent(ObjectManager manager) {
        for (var obj: list) {
            manager.addObject(obj);
        }
    }
}
