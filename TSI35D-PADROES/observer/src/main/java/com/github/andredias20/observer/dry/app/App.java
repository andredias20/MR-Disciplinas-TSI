package com.github.andredias20.observer.dry.app;

import com.github.andredias20.observer.dry.MotorEventListener;
import com.github.andredias20.observer.dry.ObservableMotor;
import com.github.andredias20.observer.dry.app.control.MotorSlowDownListener;
import com.github.andredias20.observer.dry.app.control.MotorSpeedUpListener;
import com.github.andredias20.observer.dry.app.control.MotorStartListener;
import com.github.andredias20.observer.dry.app.control.MotorStopListener;
import com.github.andredias20.observer.dry.app.view.AppView;
import com.github.andredias20.observer.fusca.motors.MotorFactory;
import com.github.andredias20.observer.motor.Motor;

public class App
{

    private Motor motor = null;
    private MotorEventListener startListener = null;
    private MotorEventListener stopListener = null;
    private MotorEventListener speedUpListener = null;
    private MotorEventListener slowDownListener = null;

    public App(Motor motor, String carImage) {
        this.startListener = new MotorStartListener();
        this.stopListener = new MotorStopListener();
        this.speedUpListener = new MotorSpeedUpListener();
        this.slowDownListener = new MotorSlowDownListener();

        ObservableMotor observable = new ObservableMotor(motor);

        observable.addStartListener(startListener);
        observable.addStopManager(stopListener);
        observable.addSpeedUpManager(speedUpListener);
        observable.addSlowDownManager(slowDownListener);

        this.motor = observable;

        this.makeView(carImage);
    }

    private void makeView(String carImage) {
        AppView view = new AppView(carImage);

        view.jbStart. addActionListener((e) -> motor.start());
        view.jbStop. addActionListener((e) -> motor.stop());
        view.jbSpeedUp. addActionListener((e) -> motor.speedUp(0.1f));
        view.jbSlowDown. addActionListener((e) -> motor.slowDown(0.25f));

        view.setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        new App(MotorFactory.create(MotorFactory.MotorType.FUSCA_1500), "images/car.jpg");
    }
}
