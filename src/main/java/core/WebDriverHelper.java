package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverHelper {
    private WebDriver wd;

    private ChromeOptions options() {
	ChromeOptions options = new ChromeOptions();
	options.setHeadless(true);// это
	options.addArguments("--headless");// и это ОДНО и ТО ЖЕ
	ChromeDriver driver = new ChromeDriver(options);
	return options;
    }

    public WebDriverHelper() {
	this.init();
    }

    private void init() {
	String os = System.getProperty("os.name").toLowerCase().replace(" ", "");
	String chromeDriver = os.contains("windows")
			? "chromedriver.exe"
			: "chromedriver_linux";
	System.setProperty("webdriver.chrome.driver", "webdriver/" + chromeDriver);
	wd = new ChromeDriver(options());
    }

    public void quit() {
	wd.close();
	wd.quit();
    }

    public void openUrl(String url) {
	wd.navigate().to(url);
    }

}
