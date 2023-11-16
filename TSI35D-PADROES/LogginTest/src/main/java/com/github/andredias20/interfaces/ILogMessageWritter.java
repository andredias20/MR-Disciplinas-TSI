package com.github.andredias20.interfaces;

import com.github.andredias20.exceptions.LogException;

public interface ILogMessageWritter {
    void write(String logMessage) throws LogException;
}
