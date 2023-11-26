package com.github.andredias20.observer.fusca.motors;

import com.github.andredias20.observer.motor.Motor;

public class MotorFactory {

    public static enum MotorType {
        FUSCA_1100,
        FUSCA_1200,
        FUSCA_1300,
        FUSCA_1500,
        FUSCA_1600

    };

    static public Motor create(MotorType type)
    {
        switch(type)
        {
            case FUSCA_1100: return new Motor1100();
            case FUSCA_1200: return new Motor1200();
            case FUSCA_1300: return new Motor1300();
            case FUSCA_1500: return new Motor1500();
            case FUSCA_1600: return new Motor1600();
        }
        throw new RuntimeException("Unknow MotorType: "+ type);
    }
}
