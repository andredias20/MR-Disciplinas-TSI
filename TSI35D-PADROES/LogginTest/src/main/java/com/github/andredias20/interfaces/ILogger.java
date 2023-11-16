package com.github.andredias20.interfaces;

import com.github.andredias20.exceptions.LogException;

public interface ILogger
{
   void log(String logMessage) throws LogException;
}
