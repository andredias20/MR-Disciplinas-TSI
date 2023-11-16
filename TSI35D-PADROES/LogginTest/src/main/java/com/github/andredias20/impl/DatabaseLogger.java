package com.github.andredias20.impl;

import com.github.andredias20.abstracts.AbstractLogger;
import com.github.andredias20.exceptions.LogException;

public class DatabaseLogger extends AbstractLogger
{
	
	//---------------------------------------------------------------------
	@Override
	protected void write(String logMessage) throws LogException
	{
		//for educational purposes only
		System.out.printf("\n'%s' was logged into databaselog", logMessage);		
	}

	//---------------------------------------------------------------------
	@Override
	protected void validate(String logMessage) throws LogException
	{
		// TODO Auto-generated method stub
	}
}
