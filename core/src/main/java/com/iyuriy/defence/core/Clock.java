package com.iyuriy.defence.core;

import java.time.Duration;

public interface Clock {

    long getTimestamp();
    long getTimestampIn(Duration period);
}
