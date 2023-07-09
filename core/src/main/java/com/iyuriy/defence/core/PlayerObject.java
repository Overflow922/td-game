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
    public void setCoords(Vec2 vec) {
        this.coords = new Vec2(vec);
    }

    @Override
    public void move(Vec2 vec) {
        coords = coords.add(vec);
    }

    @Override
    public String toString() {
        return "PlayerObject{" +
                "coords=" + coords +
                '}';
    }
}
