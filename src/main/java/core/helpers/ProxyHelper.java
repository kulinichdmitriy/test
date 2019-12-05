package core.helpers;

import core.config.Config;

public class ProxyHelper {
    public String getIp(String country) {
	String pr = Config.countryIp().getProperty(country);
	String[] mass;
	mass = pr.split(", ");
	int a = (int) (Math.random() * mass.length);
	return mass[a];
    }
}
