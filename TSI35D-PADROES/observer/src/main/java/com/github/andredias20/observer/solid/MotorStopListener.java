package com.github.andredias20.observer.solid;

import com.github.andredias20.observer.solid.MotorEvent;

public interface MotorStopListener {
    void beforeStop(MotorEvent me);
    void afterStop(MotorEvent me);
}
