package test_suites;

import org.testng.annotations.Test;

import static core.ApplicationManager.app;

public class RegistrationTest extends TestSuiteBase {

    @Test
    public void method1() {
	app().wd().openUrl("http://www.flirt.com");
	app().property().getProperty("phoenix.password");
	app().log().info("---------- TEST INFO----------");
	app().log().warning("--------- TEST WARNING---------");
	app().log().error("------------ TEST ERROR -----------");
	app().property().getProperty("");
	openSite("http://www.flirt.com");
    }

    public void openSite(String url) {
	Object object = app().rest().request()
			.when()
			.get(url)
			.then()
			.statusCode(200)
			.extract()
			.response()
			.asString();
    }
}
