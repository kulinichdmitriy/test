package core.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import java.io.PrintStream;

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
    /**
     * Get log stream
     * @return
     */
    public static PrintStream getLogStream() {
	return IoBuilder.forLogger(RestHelper.class).buildPrintStream();
    }
}
