package com.htmllogger.logger.impl;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

class Environment {

    private final static File LOGGER_DIRECTORY = new File("htmlLogs");
    private final static File LOGGER_INDEX_FILE = new File("htmlLogs/index.html");

    private Environment() {
    }

    protected static boolean createLoggerSystem() {
        if (!LOGGER_DIRECTORY.exists()) {
            if (LOGGER_DIRECTORY.mkdir()) {
                System.out.println("SHJLogger Directory was created!");
            }
        }

        if (!LOGGER_INDEX_FILE.exists()) {
            try (PrintWriter printWritter = new PrintWriter(LOGGER_INDEX_FILE)) {
                System.out.println("htmlLogs index.html was created!");
                printWritter.print("<!DOCTYPE html>");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    protected static void appendErrorToLog(List<String> logList) {
        if (LOGGER_INDEX_FILE.exists()) {
            try (PrintWriter printWriter = new PrintWriter(LOGGER_INDEX_FILE)) {
                printWriter.println("<!DOCTYPE html><html " + "style=\"background:#2e2e2e; " + "margin:0;"
                        + "font-family: arial;" + "font-size: 9pt;\"><body>\n");

                for (String log : logList) {
                    printWriter.println(log);
                }

                printWriter.print("\n<html><body>");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
