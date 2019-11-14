package test_suites;

import io.restassured.response.Response;
import org.testng.TestException;
import org.testng.annotations.Test;

import java.util.Date;

import static core.ApplicationManager.app;

public class RegistrationTest extends TestSuiteBase {

    @Test
    public void RegistrationUser() {
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
	System.out.println("email - " + app().userModel().getEmail());

	Response registrationUser = app().rest()
			.request()
			.header("X-Requested-With", "XMLHttpRequest")
			.body("UserForm[gender]=" + app().userModel().getGender()
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

	String refreshToken = registrationUser.jsonPath().get("data.refresh_token");
	String status = registrationUser.jsonPath().get("status");

	if (!status.equals("success")) {
	    throw new TestException("Registration failed, " + registrationUser.jsonPath().get("$"));
	} else {
	}
	app().userModel().setAutologinKey(refreshToken);
    }

    @Test
    public void confirmation() {
	RegistrationUser();

	Response userConfirmation = app().rest()
			.request()
			.when()
			.get("https://www.flirt.com/site/autologin/key/" + app().userModel().getAutologinKey())
			.then()
			.statusCode(200)
			.extract()
			.response();

	System.out.println(userConfirmation.asString());
    }
}