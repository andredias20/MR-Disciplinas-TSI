package com.github.andredias20.observer.listenerOldStyle;

import com.github.andredias20.observer.motor.Motor;
import com.github.andredias20.observer.motor.MotorState;

public class MotorEvent 
{
    public final Motor source;
    public final MotorState state;

    public MotorEvent(Motor source, MotorState state)
    {
        this.source =source;
        this.state = state;   
    }
}
