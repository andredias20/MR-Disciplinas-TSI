package com.github.andredias20.observer.dry;

import java.util.ArrayList;
import java.util.List;

public class MotorEventListenerManager
{
   private List<MotorEventListener> listeners = new ArrayList<>();
   public void addListener(MotorEventListener listener)
   {
      listeners.add(listener);
   }
   public void removeListener(MotorEventListener listener)
   {
      listeners.remove(listener);
   }
   public void fireBefore(MotorEvent me)
   {
      for(MotorEventListener listener : this.listeners)
         listener.before(me);
   }
   public void fireAfter(MotorEvent me)
   {
      for(MotorEventListener listener : this.listeners)
         listener.after(me);
   }
}
