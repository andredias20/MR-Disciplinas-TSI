package com.github.andredias20.observer.solid;

import com.github.andredias20.observer.solid.MotorEvent;

public interface MotorSlowDownListener {
    void beforeSlowDown(MotorEvent me);
    void afterSlowDown(MotorEvent me);
}
