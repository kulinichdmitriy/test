package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {

    private Logger log() {
	return LogManager.getLogger(getClassName(4));
    }

    private String getClassName(int depth) {
	return Thread.currentThread().getStackTrace()[depth].getClassName();
    }

    public void info(String message) {
	this.log().info(message);
    }

    public void warning(String message) {
	this.log().warn(message);
    }

    public void error(String message) {
	this.log().error(message);
    }
}
