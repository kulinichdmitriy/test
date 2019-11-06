package core;

public class ApplicationManager {

    public static ApplicationManager applicationManager;
    private WebDriverHelper webDriverHelper;
    private PropertiesHelper propertiesHelper;
    private LoggerHelper loggerHelper;
    private DateTimeHelper dateTimeHelper;

    private ApplicationManager() {
    }

    public static ApplicationManager app() {
	if (applicationManager == null) {
	    applicationManager = new ApplicationManager();
	}
	return applicationManager;
    }

    public LoggerHelper log() {
	if (loggerHelper == null) {
	    loggerHelper = new LoggerHelper();
	}
	return loggerHelper;
    }

    public WebDriverHelper wd() {
	if (webDriverHelper == null) {
	    webDriverHelper = new WebDriverHelper();
	}
	return webDriverHelper;
    }

    public PropertiesHelper property() {
	if (propertiesHelper == null) {
	    propertiesHelper = new PropertiesHelper("project.properties");
	}
	return propertiesHelper;
    }

    public DateTimeHelper dateTime() {
	if (dateTimeHelper == null) {
	    dateTimeHelper = new DateTimeHelper();
	}
	return dateTimeHelper;
    }
}
