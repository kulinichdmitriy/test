package core.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static core.ApplicationManager.app;

public class PropertiesHelper {
    private Properties properties;

    public PropertiesHelper(String filename) {
	try {
	    app().log().info("Open properties file: " + filename);

	    FileInputStream fis = new FileInputStream("src/main/resources/" + filename);
	    properties = new Properties();
	    properties.load(fis);
	} catch (IOException e) {
	    app().log().error("No property file: " + e);
	}
    }

    public String getProperty(String property) {
	app().log().info("Get property: [" + property + "]");
	return properties.getProperty(property);
    }
}
