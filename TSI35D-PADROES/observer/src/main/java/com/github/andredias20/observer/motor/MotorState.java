package com.github.andredias20.observer.motor;

public interface MotorState extends Cloneable {
    public enum Status {ON, OFF};

    public Status currentStatus();
    public float rotationsPerMinute();
    public float accelerationFraction();

    public MotorState clone();
    public static String stringfy(){
        var builder = new StringBuilder();
        builder.append("{ \n");
        builder.append(" ");
        builder.append(" \n");
        builder.append(" ");
        builder.append(" \n");
        builder.append(" ");
        builder.append(" \n");
        builder.append(" ");
        builder.append(" \n");
        builder.append(" ");
        builder.append(" \n }");
        return builder.toString();
    }
}
