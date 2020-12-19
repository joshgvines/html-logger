package com.htmllogger.logger.impl;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

public class HTMLLoggerImplTest extends TestCase {
    private static HTMLLoggerImpl cut;
    private final String LOG_LOCATION = "htmlLogs/index.html";

    @Before
    public void setUp() {
        given_RemoveOldLogFile();
    }

    @After
    public void tearDown() {
        cut = null;
    }

    @Test
    public void testLogFileCreation() {
        if (Paths.get(LOG_LOCATION).toFile().exists()) {
            Paths.get(LOG_LOCATION).toFile().delete();
        }

        cut = HTMLLoggerImpl.getLogger();

        for (int i = 0; i < 10; i++) {
            cut.log("TEST_CUSTOM_PRIORITY", "Test logger message.");
            cut.okay("Test 'okay' logger message.");
            cut.error("Test 'error' logger message.");
            cut.rip("Test 'rip' logger message.");
        }

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cut.log("ThreadOne", "thread one error message");
                    for (int i = 0; i < 6; i++) {
                        cut.log("ThreadOne", "thread one error message --- " + i);
                        System.out.println(Thread.currentThread().getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Thread One");
        threadOne.run();

        // Goto /SHJLogs/index.html in a browser to see log display
        assertTrue(Paths.get(LOG_LOCATION).toFile().exists());
    }

    private void given_RemoveOldLogFile() {
        if (Paths.get(LOG_LOCATION).toFile().exists()) {
            Paths.get(LOG_LOCATION).toFile().delete();
        }
        assertFalse(Paths.get(LOG_LOCATION).toFile().exists());
    }
}