package com.github.andredias20.abstracts;

import com.github.andredias20.interfaces.ILogMessageValidator;
import com.github.andredias20.interfaces.ILogMessageWritter;
import com.github.andredias20.interfaces.ILogger;
import com.github.andredias20.exceptions.LogException;

public abstract class AbstractLogger implements ILogger
{

	private ILogMessageValidator messageValidator = null;
	private ILogMessageWritter messageWritter = null;

	public AbstractLogger(ILogMessageValidator msgValidator, ILogMessageWritter iLogMessageWritter){
		this.messageValidator = msgValidator;
		this.messageWritter = iLogMessageWritter;
	}

	//------------------------------------------------------------------
	@Override
	public final void log(String logMessage) throws LogException
	{
		messageValidator.validate(logMessage);
		messageWritter.write(logMessage);
	}

   //------------------------------------------------------------------
	protected void verifyLogMessage(String logMessage) throws LogException
	{
		if(logMessage == null)
			throw new LogException("Message cannot be null!");
		
		if(logMessage.isBlank() || logMessage.isEmpty())
			throw new LogException("Message cannot be empty!");

		messageValidator.validate(logMessage);
	}
	
	//------------------------------------------------------------------
}
