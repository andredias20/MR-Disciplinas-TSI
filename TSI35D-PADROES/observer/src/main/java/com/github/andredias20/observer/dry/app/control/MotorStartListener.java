package com.github.andredias20.observer.dry.app.control;

import com.github.andredias20.observer.dry.MotorEvent;
import com.github.andredias20.observer.dry.MotorEventListener;
import com.github.andredias20.observer.motor.MotorState;

public class MotorStartListener implements MotorEventListener {
    @Override
    public void before(MotorEvent me) {
        System.out.println("before start "+ MotorState.stringfy(me.state));
    }

    @Override
    public void after(MotorEvent me) {
        System.out.println("after start "+ MotorState.stringfy(me.state));
    }
}
