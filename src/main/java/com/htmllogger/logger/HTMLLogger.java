package com.htmllogger.logger;

public interface HTMLLogger {

    /**
     * Allow client to create a custom priority that will show up in the log.
     * 
     * @param customPriority
     * @param errorMessage
     */
    public void log(String customPriority, String errorMessage);

    /**
     * Will print a priority of 'OKAY' to the log, which means the error was
     * expected
     * 
     * @param errorMessage
     */
    public void okay(String errorMessage);

    /**
     * Will print a priority of 'ERROR' to the log, which means the error was
     * unexpected or could cause problems.
     * 
     * @param errorMessage
     */
    public void error(String errorMessage);

    /**
     * Will print a priority of 'RIP' to the log, which means the error was
     * unexpected and will cause problems for the application. Short for (Rest In
     * Peace)
     * 
     * @param errorMessage
     */
    public void rip(String errorMessage);

}
