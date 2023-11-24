package com.github.andredias20.observer.solid;

import com.github.andredias20.observer.solid.MotorEvent;

public interface MotorSpeedUpListener {
    void beforeSpeedUp(MotorEvent me);
    void afterSpeedUp(MotorEvent me);
}
