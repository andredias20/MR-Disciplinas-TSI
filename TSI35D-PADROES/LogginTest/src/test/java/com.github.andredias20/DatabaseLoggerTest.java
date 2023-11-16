package com.github.andredias20;

import static org.junit.jupiter.api.Assertions.*;

import com.github.andredias20.impl.DatabaseLogger;
import com.github.andredias20.impl.FileLogger;
import com.github.andredias20.interfaces.ILogger;
import com.github.andredias20.exceptions.LogException;
import org.junit.jupiter.api.Test;

class DatabaseLoggerTest
{
	@Test
	void ShouldNotThrow()
	{
		ILogger logger = new DatabaseLogger();
   	   	
   	String logMessage = "Login a first message";
   	
   	assertDoesNotThrow(()->logger.log(logMessage));
	}
	
	@Test
	void ShouldThrow()
	{
		ILogger logger = new FileLogger();
   	
		final String nullMessage= null;   	
		assertThrows(LogException.class, ()->logger.log(nullMessage));

		final String blanckMessage= null;
		assertThrows(LogException.class, ()->logger.log(blanckMessage));
	}
}
