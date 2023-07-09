package com.iyuriy.defence.core.math;

import com.iyuriy.defence.core.Vec2;

public class MathUtils {
    private MathUtils() {}

    public static Vec2 getDelta(Vec2 pos, Vec2 endPos, double speed) {
        Vec2 tmp = endPos.minus(pos);
        double len = tmp.getLength();
        if (len < speed)
            return new Vec2(endPos);
        tmp = tmp.normalize();
        return tmp.multiply(speed);
    }
}
