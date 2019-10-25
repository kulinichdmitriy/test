package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test_suites.TestSuiteBase;

public class LoggerHelper {

    public Logger log = LogManager.getLogger(TestSuiteBase.class);

    public void info() {
	log.info("Info: ");
    }

    public void warning() {
	log.warn("Warning: ");
    }

    public void error() {
	log.error("Error: ");
    }
}
