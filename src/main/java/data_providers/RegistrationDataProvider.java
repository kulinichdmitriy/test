package data_providers;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {

    @DataProvider(name = "regDataProvider")
    public static Object[][] regDataProvider() {
	return new Object[][] {{ "male" },{ "female" }};
    }
}
