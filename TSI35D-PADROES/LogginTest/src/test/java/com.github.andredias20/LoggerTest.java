package com.github.andredias20;

import com.github.andredias20.exceptions.LogException;
import com.github.andredias20.impl.writers.LogTextFileWritter;
import com.github.andredias20.impl.Logger;
import com.github.andredias20.impl.validators.SimpleLogMessageValidator;
import com.github.andredias20.interfaces.ILogMessageValidator;
import com.github.andredias20.interfaces.ILogMessageWritter;
import com.github.andredias20.interfaces.ILogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoggerTest {


    @Test
    void ShouldNotThrow() {
		ILogMessageValidator validator = new SimpleLogMessageValidator();
		ILogMessageWritter writer = new LogTextFileWritter();
		ILogger logger = new Logger(validator, writer);

        final String logMessage = "Login a first message";

        assertDoesNotThrow(() -> logger.log(logMessage));
    }

    @Test
    void ShouldThrow() {
		ILogMessageValidator validator = new SimpleLogMessageValidator();
		ILogMessageWritter writer = new LogTextFileWritter();
		ILogger logger = new Logger(validator, writer);

        final String nullMessage = null;
        assertThrows(LogException.class, () -> logger.log(nullMessage));

        final String blanckMessage = null;
        assertThrows(LogException.class, () -> logger.log(blanckMessage));
    }
}
