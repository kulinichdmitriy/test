package core.data_providers;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {

    @DataProvider(name = "RegDataProvider")
    public static Object[][] RegDataProvider() {
	return new Object[][] {{ "male" },{ "female" }};
    }
}
