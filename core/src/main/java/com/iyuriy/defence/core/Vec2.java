package com.iyuriy.defence.core;

import java.util.Objects;

public class Vec2 {
    private final double x,y;

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec2 that) {
        this(that.x, that.y);
    }

    public Vec2 add(Vec2 that) {
        return new Vec2(x+that.x, y+that.y);
    }

    public Vec2 minus(Vec2 that) {
        return new Vec2(x - that.x, y-that.y);
    }

    public Vec2 multiply(double a) {
        return new Vec2(x/a, y/a);
    }

    public double getLength() {
        return Math.sqrt(x*x+y*y);
    }

    public Vec2 normalize() {
        double length = getLength();
        return new Vec2(x/length, y/length);
    }

    @Override
    public String toString() {
        return "Vec2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec2 vec2 = (Vec2) o;
        return Double.compare(vec2.x, x) == 0 && Double.compare(vec2.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}