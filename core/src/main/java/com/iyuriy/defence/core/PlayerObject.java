package com.iyuriy.defence.core;

public class PlayerObject implements GameObject {
    private Vec2 coords;

    public PlayerObject(Vec2 coords) {
        this.coords = coords;
    }

    @Override
    public Vec2 getCoords() {
        return coords;
    }

    @Override
    public void move(double x, double y) {
            coords.x = coords.x + x;
            coords.y = coords.y + y;
    }


}
