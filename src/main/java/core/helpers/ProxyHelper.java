package core.helpers;

import static core.ApplicationManager.app;

public class ProxyHelper {
    private PropertiesHelper property;

    public ProxyHelper() {
	property = new PropertiesHelper("country_ip.properties");
    }

    public String getProxyIp(String prop) {
	app().log().info("Get property: [ " + prop + " ] from file");

	String pr = property.getProperty(prop);
	String[] mass;
	String delimetr = ", ";
	mass = pr.split(delimetr);
	int a = (int) (Math.random() * mass.length);
	return mass[a];
    }
}