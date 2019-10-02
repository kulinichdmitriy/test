package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {
    private WebDriver wd;

    public void init() {
	String pathToChromeDriver = "Z:\\eclipse_projects\\maven\\webdriver\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
	wd = new ChromeDriver();
    }

    public void close() {
	wd.close();
    }

    public void openUrl(String url) {
	wd.navigate().to(url);
    }
}
