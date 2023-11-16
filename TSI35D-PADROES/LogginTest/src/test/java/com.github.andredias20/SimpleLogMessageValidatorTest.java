package com.github.andredias20;

import com.github.andredias20.impl.SimpleLogMessageValidator;
import com.github.andredias20.interfaces.ILogMessageValidator;
import com.github.andredias20.exceptions.LogException;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Testable
public class SimpleLogMessageValidatorTest
{
    @Test
    void ShouldNotThrow()
    {
        ILogMessageValidator logger = new SimpleLogMessageValidator();

        String logMessage = "Login a first message";

        assertDoesNotThrow(()->logger.validate(logMessage));
    }

    @Test
    void ShouldThrow()
    {
        ILogMessageValidator logger = new SimpleLogMessageValidator();

        final String nullMessage= null;
        assertThrows(LogException.class, ()->logger.validate(nullMessage));

        final String blanckMessage= null;
        assertThrows(LogException.class, ()->logger.validate(blanckMessage));
    }
}
