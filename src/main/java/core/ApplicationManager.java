package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test_suites.TestSuiteBase;

public class ApplicationManager {

    public Logger log = LogManager.getLogger(TestSuiteBase.class);

    private WebDriverHelper webDriverHelper;
    private PropertiesHelper propertiesHelper;

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