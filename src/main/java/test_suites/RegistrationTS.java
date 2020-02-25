package test_suites;

import data_providers.RegistrationDataProvider;
import org.testng.annotations.Test;
import test_objects.RegistrationTest;

import static core.ApplicationManager.app;

public class RegistrationTS extends TestSuiteBase {

    RegistrationTest reg = new RegistrationTest();

    @Test(dataProvider = "regDataProvider", dataProviderClass = RegistrationDataProvider.class, priority = 1)
    public void registration(String gender, String orientation, String pass, int age) {

	reg.registration(gender, orientation, pass, age);
	reg.confirmation();
	app().rest().clearCookie();
    }
}
