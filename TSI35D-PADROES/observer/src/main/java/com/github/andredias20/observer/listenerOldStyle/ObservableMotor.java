package observer.listenerOldStyle;

import observer.motor.Motor;
import observer.motor.MotorState;

public class ObservableMotor implements Motor
{
   private final Motor motor;

   private final MotorListenerManager listenerManager =     
                            new MotorListenerManager();

   //-----------------------------------------------------
   public ObservableMotor(Motor motor)
   {
      this.motor = motor;
   }

    //-----------------------------------------------------
	@Override
	public MotorState getState()
	{
		return motor.getState();
	}
	
	//-----------------------------------------------------
	@Override
	public boolean isOn()
	{
		return motor.isOn();
	}
	
	//-----------------------------------------------------
	@Override
	public boolean isOff()
	{
		return motor.isOff();
	}
	
	//-----------------------------------------------------
	@Override
	public void slowDown(float percent)
	{
	    listenerManager.fireBeforeSlowDown(new MotorEvent(motor, motor.getState()));
		motor.slowDown(percent);
		listenerManager.fireAfterSlowDown(new MotorEvent(motor, motor.getState()));
	}
		
	//-----------------------------------------------------
	@Override
	public void speedUp(float percent)
	{
		listenerManager.fireBeforeSpeedUp(new MotorEvent(motor, motor.getState()));
		motor.speedUp(percent);
		listenerManager.fireAfterSpeedUp(new MotorEvent(motor, motor.getState()));
	}
	
	//-----------------------------------------------------
	@Override
	public void start()
	{
		listenerManager.fireBeforeStart(new MotorEvent(motor, motor.getState()));
		motor.start();
		listenerManager.fireAfterStart(new MotorEvent(motor, motor.getState()));
	}
	
	//-----------------------------------------------------
	@Override
	public void stop()
	{
		listenerManager.fireBeforeStop(new MotorEvent(motor, motor.getState()));
		motor.stop();
		listenerManager.fireAfterStop(new MotorEvent(motor, motor.getState()));
	}
	
	//-----------------------------------------------------
	public void addMotorListener(MotorListener listener)
	{
		listenerManager.addMotorListener(listener);
	}
	
	//-----------------------------------------------------
	public void removeMotorListener(MotorListener listener)
	{
		listenerManager.removeMotorListener(listener);
	}
}
