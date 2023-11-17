package com.github.andredias20.observer.listenerOldStyle;

import com.github.andredias20.observer.motor.Motor;

public class ObservableMotor implements Motor{
    private final Motor motor;
    private final MotorListenerManager listenerManager = new MotorListenerManager();

    public ObservableMotor(Motor motor){
        this.motor = motor;
    }
}
