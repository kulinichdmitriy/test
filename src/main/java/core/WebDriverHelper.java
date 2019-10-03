package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {
    private WebDriver wd;

    public WebDriverHelper() {
	this.init();
    }

    private void init() {
	String os = System.getProperty("os.name").toLowerCase().replace(" ", "");
	String chromeDriver = os.contains("windows")
			? "chromedriver.exe"
			: "chromedriver_linux";
	System.setProperty("webdriver.chrome.driver", "webdriver/" + chromeDriver);
	wd = new ChromeDriver();
    }

    public void close() {
	wd.close();
    }

    public void openUrl(String url) {
	wd.navigate().to(url);
    }
}
