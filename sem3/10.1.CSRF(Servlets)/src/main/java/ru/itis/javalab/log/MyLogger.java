package ru.itis.javalab.log;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MyLogger.class);

    public static void logMessage(String message){
        logger.info(message);
    }
}
