package com.iyuriy.defence.core;

public interface GameObject {
    Vec2 getCoords();
    void setCoords(Vec2 vec);
    void move(Vec2 delta);
}
