package com.github.andredias20.impl.validators;

import com.github.andredias20.interfaces.ILogMessageValidator;
import com.github.andredias20.exceptions.LogException;

public class SimpleLogMessageValidator implements ILogMessageValidator {

    final String invalidMessage = "Invalid Log Message";

    @Override
    public void validate(String message) throws LogException {
        if(message == null)
            throw new LogException(invalidMessage+" ( NULL )");

        if(message.isEmpty())
            throw new LogException(invalidMessage+ " ( Empty )");

        if(message.toUpperCase().contains("XPTO"))
            throw new LogException(invalidMessage+ " (it contains XPTO");
    }
}
