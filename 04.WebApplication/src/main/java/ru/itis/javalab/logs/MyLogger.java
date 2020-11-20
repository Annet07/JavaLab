package ru.itis.javalab.logs;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MyLogger.class);

    public static void logMessage(String message){
        logger.info(message);
    }
}
