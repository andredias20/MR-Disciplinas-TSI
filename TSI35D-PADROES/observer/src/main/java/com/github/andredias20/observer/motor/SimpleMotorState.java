package com.github.andredias20.observer.motor;

public class SimpleMotorState implements MotorState
{
	Status currentStatus = Status.OFF;
	float rpm = 0.0f;
	float accelerationFraction = 0.0f;
	
	//----------------------------------------------------------
	public SimpleMotorState( 
            Status currentStatus, 
            float rpm, 
            float accelerationFraction )
	{
		super();
		this.currentStatus = currentStatus;
		this.rpm = rpm;
		this.accelerationFraction = accelerationFraction;
	}

	//----------------------------------------------------------
	@Override
	public MotorState.Status currentStatus()
	{
		return currentStatus;
	}

	//----------------------------------------------------------
	@Override
	public float rotationsPerMinute()
	{
		return rpm;
	}

	//----------------------------------------------------------
	@Override
	public float accelerationFraction()
	{
		return accelerationFraction;
	}

	//----------------------------------------------------------
	public MotorState clone()
	{
	   try 
	   {
	      Object clone = super.clone();
	      return (MotorState)clone;
	   } 
	   catch (CloneNotSupportedException e) 
	   {
	      //should never be executed
	      e.printStackTrace();
	      return null;
	   }
	}
	
	//----------------------------------------------------------
	private boolean areEquals(float valueA, float valueB)
	{
	   final float dif = valueA - valueB;    
	   return ( Math.abs(dif) < 0.000_000_1 );
	}

	//----------------------------------------------------------
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof SimpleMotorState))
			return false;
	   
		SimpleMotorState another = (SimpleMotorState) other;

	    boolean areEquals = (( this.currentStatus() == another.currentStatus()) &&
	    	areEquals(this.rotationsPerMinute(), another.rotationsPerMinute()) &&
	    	areEquals(this.accelerationFraction(), another.accelerationFraction()) 
	    );

	    return areEquals;
	}

}
