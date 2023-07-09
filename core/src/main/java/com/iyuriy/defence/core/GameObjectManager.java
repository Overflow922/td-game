package com.iyuriy.defence.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameObjectManager implements ObjectManager {

    private final Map<String, GameObject> objects = new ConcurrentHashMap<>();

    @Override
    public String addObject(GameObject object) {
        String key = generateKey(object);
        objects.put(key, object);
        return key;
    }

    private String generateKey(GameObject object) {
        return object.getClass().getSimpleName() + object.hashCode();
    }
}
