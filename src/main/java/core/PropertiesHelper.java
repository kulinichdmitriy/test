package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static core.ApplicationManager.app;

public class PropertiesHelper {

    private Properties property;

    public PropertiesHelper(String path) {
	try {
	    app().log().info("Open Properies file - " + path);
	    FileInputStream fis = new FileInputStream("src/main/resources/"+path);
	    property = new Properties();
	    property.load(fis);
	} catch (IOException e) {
	    app().log().error("No property file: " + e);
	}
    }

    public String getProperty(String prop) {
	app().log().info("Get property - " + prop + " - from file");
	String pr = property.getProperty(prop);
	return pr;
    }
}
