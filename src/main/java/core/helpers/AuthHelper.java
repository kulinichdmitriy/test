package core.helpers;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

import static core.ApplicationManager.app;

public class AuthHelper {

    public void authPhoenix() {

	ValidatableResponse login = app().rest().request()
			.auth().preemptive().basic(app().property().getProperty("phoenix.login"), app().property().getProperty("phoenix.password"))
			.when()
			.get(app().property().getProperty("phoenix.login.url"))
			.then()
			.statusCode(302)
			.header("location", Matchers.equalTo(app().property().getProperty("phoenix.base.url")));

    }
}
