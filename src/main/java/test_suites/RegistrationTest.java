package test_suites;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Date;

import static core.ApplicationManager.app;

public class RegistrationTest extends TestSuiteBase {

    @Test
    public void registration() {
	String email = "dmitriykulinich" + (new Date()).getTime() + "@maildrop.ropot.net";
	app().log().info(email);
	String password = "asdasd123";
	String gender = "male";
	String sexualOrientation = "hetero";
	String age = "21";
	String location = "Dnipropetrovsk,+49000";
	String termsConsent = "true";
	String policyConsent = "true";

	ValidatableResponse response = app().rest()
			.request()
			.body("UserForm[gender]=" + gender + "&UserForm[sexual_orientation]=" + sexualOrientation + "&UserForm[age]=" + age + "&UserForm[location]=" + location
					+ "&UserForm[email]=" +
					email + "&UserForm[password]=" + password + "&UserForm[termsConsent]=" + termsConsent + "&UserForm[policyConsent]=" + policyConsent
					+ "&UserForm[lid"
					+ "]=3830403ea31a11e9a8911402ec33333c&UserForm[landingVisitId]=4361e4417c576200f02c81c7ecc54eab&UserForm[splitId]=&UserForm[transferId]=b106b41c55f449ae84e2d050b981bed9")
			.when()
			.post("https://www.flirt.com/user/register")
			.then()
			.statusCode(302)
			.header("location", Matchers
					.equalTo("https://www.flirt.com/confirmation"));

    }
}
