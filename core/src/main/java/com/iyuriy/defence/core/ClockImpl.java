package com.iyuriy.defence.core;

import java.time.Duration;

public class ClockImpl implements Clock {
    @Override
    public long getTimestamp() {
        return System.nanoTime();
    }

    @Override
    public long getTimestampIn(Duration period) {
        return getTimestamp() + period.toNanos();
    }
}
