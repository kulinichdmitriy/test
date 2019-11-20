package test_suites;

import data_providers.RegistrationDataProvider;
import org.testng.annotations.Test;
import test_objects.RegistrationTest;

import static core.ApplicationManager.app;

public class RegistrationTS extends TestSuiteBase {

    RegistrationTest test = new RegistrationTest();

    @Test(dataProvider = "regDataProvider", dataProviderClass = RegistrationDataProvider.class, priority = 1)
    public void registration(String gender) {
	test.registration(gender);
	test.confirmation();
	app().rest().clearCookie();
    }
}
