package core.helpers;

import static core.ApplicationManager.app;

public class ProxyHelper {
    public String getProxyIp(String country) {

	String getIp = app().property().getProperty(country);
	String[] mass;
	String delimetr = "-";
	mass = getIp.split(delimetr);
	int a = (int) (Math.random() * 5);
	return mass[a];
    }
}
