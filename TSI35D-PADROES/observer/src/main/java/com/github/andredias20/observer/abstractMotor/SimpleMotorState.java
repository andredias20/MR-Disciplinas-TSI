package com.github.andredias20.observer.abstractMotor;

import com.github.andredias20.observer.motor.MotorState;

public class SimpleMotorState implements MotorState
{
        Status currentStatus = Status.OFF;
        float rpm = 0.0f;
        float accelerationFraction = 0.0f;

    public SimpleMotorState( Status currentStatus,
                             float rpm,
                             float accelerationFraction)
    {
        super();
        this.currentStatus = currentStatus;
        this.rpm = rpm;
        this.accelerationFraction = accelerationFraction;
    }

    @Override
    public Status currentStatus() {
        return null;
    }

    @Override
    public float rotationsPerMinute() {
        return 0;
    }

    @Override
    public float accelerationFraction() {
        return 0;
    }

    @Override
    public MotorState clone() {
        try{
            Object clone = super.clone();
            return (MotorState) clone;
        }catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private boolean areEquals(float a, float b){
        final float dif = a - b;
        return (Math.abs(dif) < 0.000_000_1);
    }

    @Override
    public boolean equals(Object other) {
        SimpleMotorState another = new (SimpleMotorState) other;

        boolean areEquals = ((this.currentStatus() == another.currentStatus()) &&
                areEquals(this.rotationsPerMinute(), another.rotationsPerMinute()) &&
                areEquals());
        return areEquals;
    }
}