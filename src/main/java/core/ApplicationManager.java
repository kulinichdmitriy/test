package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test_suites.TestSuiteBase;

public class ApplicationManager {

    public static ApplicationManager applicationManager;
    private WebDriverHelper webDriverHelper;
    private PropertiesHelper propertiesHelper;
    public Logger log = LogManager.getLogger(TestSuiteBase.class);

    private ApplicationManager() {
    }

    public static ApplicationManager app() {
	if (applicationManager == null) {
	    applicationManager = new ApplicationManager();
	}
	return applicationManager;
    }

    public WebDriverHelper wd() {
	if (webDriverHelper == null) {
	    webDriverHelper = new WebDriverHelper();
	}
	return webDriverHelper;
    }

    public PropertiesHelper property() {
	if (propertiesHelper == null) {
	    propertiesHelper = new PropertiesHelper();
	}
	return propertiesHelper;
    }
}