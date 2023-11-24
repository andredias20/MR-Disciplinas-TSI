package com.github.andredias20.observer.listenerOldStyle;

public interface MotorListener
{
   void beforeStart(MotorEvent me);
   void afterStart(MotorEvent me);

   void beforeStop(MotorEvent me);
   void afterStop(MotorEvent me);

   void beforeSlowDown(MotorEvent me);
   void afterSlowDown(MotorEvent me);

   void beforeSpeedUp(MotorEvent me);
   void afterSpeedUp(MotorEvent me);

}
