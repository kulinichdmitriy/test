package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private Logger log = LogManager.getLogger(PropertiesHelper.class);
    private Properties property;

    public PropertiesHelper() {
	try {
	    FileInputStream fis = new FileInputStream("src/main/resources/project.properties");
	    property = new Properties();
	    property.load(fis);
	} catch (IOException e) {
	    log.error("No property file: " + e);
	}

    }

    public String get(String prop) {
	String pr = property.getProperty(prop);
	return pr;
    }
}
