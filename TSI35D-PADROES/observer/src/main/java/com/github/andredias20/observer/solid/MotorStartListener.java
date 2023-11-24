package com.github.andredias20.observer.solid;

import com.github.andredias20.observer.solid.MotorEvent;

public interface MotorStartListener {
    void beforeStart(MotorEvent me);
    void afterStart(MotorEvent me);
}
