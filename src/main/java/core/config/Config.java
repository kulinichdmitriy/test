package core.config;

import core.helpers.PropertiesHelper;

public class Config {
    private static PropertiesHelper accessProperties;
    private static PropertiesHelper countryIpProperties;
    private static PropertiesHelper projectProperties;

    /**
     * Get Access properties instance
     *
     * @return PropertiesHelper
     */
    public static PropertiesHelper access() {
	if (accessProperties == null) {
	    accessProperties = new PropertiesHelper("access.properties");
	}
	return accessProperties;
    }

    /**
     * Get Country ip properties instance
     *
     * @return PropertiesHelper
     */
    public static PropertiesHelper countryIp() {
	if (countryIpProperties == null) {
	    countryIpProperties = new PropertiesHelper("country_ip.properties");
	}
	return countryIpProperties;
    }

    /**
     * Get Project properties instance
     *
     * @return PropertiesHelper
     */
    public static PropertiesHelper project() {
	if (projectProperties == null) {
	    projectProperties = new PropertiesHelper("project.properties");
	}
	return projectProperties;
    }
}
