package com.github.andredias20.impl.writers;

import com.github.andredias20.exceptions.LogException;
import com.github.andredias20.interfaces.ILogMessageWritter;

public class LogNoSQLDatabaseWritter implements ILogMessageWritter {
    @Override
    public void write(String logMessage) throws LogException {
        System.out.printf("\n'%s' was logged into databaselog, by LogNoSQLDatabaseWritter", logMessage);
    }
}
