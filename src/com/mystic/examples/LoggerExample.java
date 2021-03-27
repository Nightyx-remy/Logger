package com.mystic.examples;

import com.mystic.logger.Logger;

/**
 * Example for the {@link Logger} class
 */
public class LoggerExample {

    public static void main(String[] args) {
        Logger.logLevel = Logger.WARN_LEVEL; // Set the log level to warn (get rid of log info)

        Logger.info("Test", "This is a test");
        Logger.warn("Test", "This is a test");
        Logger.error("Test", "This is a test");
        Logger.critical("Test", "This is a test");
    }

}
