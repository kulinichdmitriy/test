package core.data_providers;

import org.testng.annotations.DataProvider;

import java.util.Date;

import static core.ApplicationManager.app;

public class RegistrationDataProvider {

    @DataProvider(name = "registrationDataProvider")
    public Object[][] registrationData() {

	return new Object[][]
			{
					{ "dmitriykulinich" + (new Date()).getTime() + "@maildrop.ropot.net" },
					{ "asdasd123" },
					{ "male", "female" },
					{ "homo", "hetero" },
					{ 18, 35, 60, 79 },
					{ "Dnipropetrovsk,+49000" },
					{ app().userModel().getAutologinKey() },
					{ app().userModel().getCsrfToken() }

			};

    }
}
