package core;

public class ApplicationManager {
    private WebDriverHelper webDriverHelper;

    /**
     * Get WebDriverHelper instance
     * @return WebDriverHelper
     */
    public WebDriverHelper wd() {
	if (webDriverHelper == null) {
	    webDriverHelper = new WebDriverHelper();
	}
	return webDriverHelper;
    }
}
