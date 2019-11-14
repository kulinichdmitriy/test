package core.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static core.ApplicationManager.app;

public class WebDriverHelper {
    private WebDriver wd;

    public WebDriverHelper() {
	this.init();
    }

    private ChromeOptions getChromeOptions() {
	ChromeOptions options = new ChromeOptions();
	options.setHeadless(false);
	//options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 7.0; SM-G930V Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko)"
	//+ "Chrome/59.0.3071.125 Mobile "
	//+ "Safari/537.36");
	return options;
    }

    private void init() {
	app().log().info("Init Chrome Driver ");

	String os = System.getProperty("os.name").toLowerCase().replace(" ", "");
	String chromeDriver = os.contains("windows")
			? "chromedriver.exe"
			: "chromedriver_linux";
	System.setProperty("webdriver.chrome.driver", "webdriver/" + chromeDriver);
	wd = new ChromeDriver(this.getChromeOptions());
    }

    public void quit() {
	app().log().info("Close Chrome Driver ");

	wd.close();
	wd.quit();
    }

    public void openUrl(String url) {
	app().log().info("Open URL: [ " + url + " ]");

	wd.navigate().to(url);
    }
}
