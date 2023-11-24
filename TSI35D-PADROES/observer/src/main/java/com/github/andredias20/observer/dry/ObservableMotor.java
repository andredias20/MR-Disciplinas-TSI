package com.github.andredias20.observer.dry;

import com.github.andredias20.observer.motor.Motor;
import com.github.andredias20.observer.motor.MotorState;

public class ObservableMotor implements Motor {

    private Motor motor = null;

    public ObservableMotor(Motor motor){
        this.motor = motor;
    }

    @Override
    public MotorState getState() {
        return motor.getState();
    }

    @Override
    public boolean isOn() {
        return motor.isOn();
    }

    @Override
    public boolean isOff() {
        return motor.isOff();
    }

    //Observer pattern
    private final MotorEventListenerManager startManager = new MotorEventListenerManager();
    private final MotorEventListenerManager stopManager = new MotorEventListenerManager();
    private final MotorEventListenerManager speedUpManager = new MotorEventListenerManager();
    private final MotorEventListenerManager slowDownManager = new MotorEventListenerManager();

    public void addStartListener(MotorEventListener listener)
    {
        startManager.addListener(listener);
    }
    public void removeStartListener(MotorEventListener listener)
    {
        startManager.removeListener(listener);
    }
    public void addStopManager(MotorEventListener listener)
    {
        stopManager.addListener(listener);
    }
    public void removeStopManager(MotorEventListener listener)
    {
        stopManager.removeListener(listener);
    }
    public void addSpeedUpManager(MotorEventListener listener)
    {
        speedUpManager.addListener(listener);
    }
    public void removeSpeedUpManager(MotorEventListener listener)
    {
        speedUpManager.removeListener(listener);
    }
    public void addSlowDownManager(MotorEventListener listener)
    {
        slowDownManager.addListener(listener);
    }
    public void removeSlowDownManager(MotorEventListener listener)
    {
        slowDownManager.removeListener(listener);
    }


}
