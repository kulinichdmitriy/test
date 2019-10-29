package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test_suites.TestSuiteBase;

public class LoggerHelper {

    public Logger log = LogManager.getLogger(getClassName(4));

    private String getClassName(int depth) {
	return Thread.currentThread().getStackTrace()[depth].getClassName();
    }

    public void info(String message) {
	log.info(message);
    }

    public void warning(String message) {
	log.warn(message);
    }

    public void error(String message) {
	log.error(message);
    }
}
