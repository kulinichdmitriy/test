package core.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static core.ApplicationManager.app;

public class ProxyHelper {
    private Properties property;

    public ProxyHelper() {
	String filename = "country_ip.properties";
	try {
	    app().log().info("Open Properies file: [ " + filename + " ]");

	    FileInputStream fis = new FileInputStream("src/main/resources/" + filename);
	    property = new Properties();
	    property.load(fis);
	} catch (IOException e) {
	    app().log().error("No property file: " + e);
	}
    }

    public String getProxyIp(String prop) {
	app().log().info("Get property: [ " + prop + " ] from file");

	String pr = property.getProperty(prop);
	String[] mass;
	String delimetr = ", ";
	mass = pr.split(delimetr);
	int a = (int) (Math.random() * 4);
	return mass[a];
    }

}
