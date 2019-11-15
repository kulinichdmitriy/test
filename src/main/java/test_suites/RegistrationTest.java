package test_suites;

import core.data_providers.RegistrationDataProvider;
import io.restassured.response.Response;
import org.testng.TestException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Date;
import static core.ApplicationManager.app;

public class RegistrationTest extends TestSuiteBase {

    RegistrationDataProvider dp = new RegistrationDataProvider();

    @Test(dataProvider = "regDataProvider", dataProviderClass = RegistrationDataProvider.class, priority = 1)
    public void registration(String gender ) {
	app().userModel().setAge(21);
	app().userModel().setEmail("dmitriykulinich" + (new Date()).getTime() + "@maildrop.ropot.net");
	app().userModel().setGenger("male");
	app().userModel().setPassword("asdasd123");
	app().userModel().setLocation("Dnipropetrovsk,+49000");
	app().userModel().setSexualOrientation("hetero");
	Boolean termsConsent = true;
	Boolean policyConsent = true;
	String lid = "3830403ea31a11e9a8911402ec33333c";
	String landingVisitId = "4361e4417c576200f02c81c7ecc54eab";
	String transferId = "b106b41c55f449ae84e2d050b981bed9";

	Response response = app().rest().request()
			.header("X-Requested-With", "XMLHttpRequest")
			.body("UserForm[gender]=" + gender//app().userModel().getGender()
					+ "&UserForm[sexual_orientation]=" + app().userModel().getSexualOrientation()
					+ "&UserForm[age]=" + app().userModel().getAge()
					+ "&UserForm[location]=" + app().userModel().getLocation()
					+ "&UserForm[email]=" + app().userModel().getEmail()
					+ "&UserForm[password]=" + app().userModel().getPassword()
					+ "&UserForm[termsConsent]=" + termsConsent
					+ "&UserForm[policyConsent]=" + policyConsent
					+ "&UserForm[lid]=" + lid
					+ "&UserForm[landingVisitId]=" + landingVisitId
					+ "&UserForm[transferId]=" + transferId)
			.when()
			.post("https://www.flirt.com/user/register")
			.then()
			.statusCode(200)
			.extract()
			.response();

	String refreshToken = response.jsonPath().get("data.refresh_token");
	String status = response.jsonPath().get("status");

	if (!status.equals("success")) {
	    throw new TestException("Registration failed, " + response.jsonPath().get("$"));
	}
	app().userModel().setAutologinKey(refreshToken);
    }

    @Test(priority = 2, dependsOnMethods = "registration")
    public void confirmation() {
	// Make autologin
	app().rest().request()
			.when()
			.get("https://www.flirt.com/site/autologin/key/" + app().userModel().getAutologinKey())
			.then()
			.statusCode(200);

	// Get csrfToken
	Response response = app().rest()
			.request()
			.header("X-Requested-With", "XMLHttpRequest")
			.when()
			.get("https://www.flirt.com/api/v1/appData")
			.then()
			.statusCode(200)
			.extract()
			.response();

	app().userModel().setCsrfToken(response.jsonPath().get("data.csrfToken.value").toString());
	app().log().info(response.jsonPath().get("data.csrfToken.value").toString());
	app().wd().clearCookie();
    }
}
