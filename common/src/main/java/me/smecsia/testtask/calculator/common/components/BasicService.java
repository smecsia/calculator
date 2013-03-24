package me.smecsia.testtask.calculator.common.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (c) 2012 i-Free. All Rights Reserved.
 *
 * @author Ilya Sadykov
 *         Date: 27.09.12
 *         Time: 18:51
 */
public abstract class BasicService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Debug message
     *
     * @param m message
     */
    protected void debug(String m) {
        if (logger.isDebugEnabled()) {
            logger.debug(m);
        }
    }

    /**
     * Log info error
     *
     * @param e error
     */
    protected void log(Throwable e) {
        logger.info("", e);
    }

    /**
     * Log info message
     *
     * @param m message
     */
    protected void log(String m) {
        logger.info(m);
    }

    /**
     * Log warn message
     *
     * @param m message
     */
    protected void warn(String m) {
        logger.warn(m);
    }

    /**
     * Log and throw the exception next
     *
     * @param e exception
     */
    protected void logAndThrow(Throwable e) {
        logger.error(e.getMessage(), e);
        throw new RuntimeException(e);
    }

    /**
     * Log and throw the exception next
     *
     * @param e exception
     */
    protected void logAndThrow(RuntimeException e) {
        logger.error(e.getMessage(), e);
        throw e;
    }

    protected void logAndThrow(String message) throws RuntimeException {
        logAndThrow(new RuntimeException(message));
    }

}
