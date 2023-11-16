package com.github.andredias20.impl;

import com.github.andredias20.abstracts.AbstractLogger;
import com.github.andredias20.exceptions.LogException;

public class FileLogger extends AbstractLogger
{
	//-----------------------------------------------------------------
	@Override
	protected void write(String logMessage) throws LogException
	{
		//for educational purposes only
		System.out.printf("\n'%s' was logged into fileLog", logMessage);
	}
	
	//-----------------------------------------------------------------
	@Override
	protected void validate(String logMessage) throws LogException
	{
		if(logMessage.contains("XPTO"))
			throw new LogException("Message cannot contain XPTO");
	}
}
