package com.htmllogger.logger.impl;

import com.htmllogger.enums.Priority;
import com.htmllogger.logger.HTMLLogger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class HTMLLoggerImpl implements HTMLLogger {

    private static volatile HTMLLoggerImpl logger = null;
    private static volatile List<String> logList = new ArrayList<>();
    private static volatile boolean isEnvironmentBuilt = false;

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    private Date date = new Date(System.currentTimeMillis());

    private HTMLLoggerImpl() {
        if (!isEnvironmentBuilt) {
            isEnvironmentBuilt = Environment.createLoggerSystem();
        }
    }

    @Override
    public void log(String customPriority, final String errorMessage) {
        buildLog(Priority.CUSTOM.getPriority() + customPriority + " : ", errorMessage);
    }

    @Override
    public void okay(final String errorMessage) {
        buildLog(Priority.OKAY.getPriority(), errorMessage);
    }

    @Override
    public void error(final String errorMessage) {
        buildLog(Priority.ERROR.getPriority(), errorMessage);
    }

    @Override
    public void rip(final String errorMessage) {
        buildLog(Priority.RIP.getPriority(), errorMessage);
    }

    /**
     * Add content to the logs that will be added to index.html
     * @param logUpdate
     * @param errorMessage
     */
    private void buildLog(String logUpdate, final String errorMessage) {
        if (errorMessage != null) {
            logUpdate = logUpdate + formatter.format(date) + "\n <br> MSG : " + errorMessage + "</p>";

            logList.add(logUpdate);
            if (!logList.isEmpty()) {
                Environment.appendErrorToLog(logList);
            }
        } else {
            System.out.println("Failed to log error!");
        }
    }

    /**
     * Lazy initialization Singleton
     *
     * @return static instance of SHJLoggerImpl
     */
    public static synchronized HTMLLoggerImpl getLogger() {
        if (logger == null) {
            synchronized (HTMLLoggerImpl.class) {
                if (logger == null) {
                    logger = new HTMLLoggerImpl();
                }
            }
        }
        return logger;
    }

}
