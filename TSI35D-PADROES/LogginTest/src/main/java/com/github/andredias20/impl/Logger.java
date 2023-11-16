package com.github.andredias20.impl;

import com.github.andredias20.abstracts.AbstractLogger;
import com.github.andredias20.interfaces.ILogMessageValidator;
import com.github.andredias20.interfaces.ILogMessageWritter;

public class Logger extends AbstractLogger {
    public Logger(ILogMessageValidator msgValidator, ILogMessageWritter iLogMessageWritter) {
        super(msgValidator, iLogMessageWritter);
    }
}
