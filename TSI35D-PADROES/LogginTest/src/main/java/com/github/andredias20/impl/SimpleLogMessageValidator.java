package com.github.andredias20.impl;

import com.github.andredias20.interfaces.ILogMessageValidator;
import com.github.andredias20.exceptions.LogException;

public class SimpleLogMessageValidator implements ILogMessageValidator {
    @Override
    public void validate(String message) throws LogException {
        if(message == null)
            throw new LogException("Message cannot be null!");

        if(message.isEmpty())
            throw new LogException("Message cannot be empty");
    }
}
