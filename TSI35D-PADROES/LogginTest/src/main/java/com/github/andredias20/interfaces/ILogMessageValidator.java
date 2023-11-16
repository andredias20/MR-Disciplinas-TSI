package com.github.andredias20.interfaces;

import com.github.andredias20.exceptions.LogException;

public interface ILogMessageValidator {
    void validate(String message) throws LogException;
}
