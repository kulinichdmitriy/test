package test_suites;

import core.data_models.UserModel;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Date;

import static core.ApplicationManager.app;

public class RegistrationTest extends TestSuiteBase {

    @Test
    public void registration() {


	app().userMod().setAge(21);
	app().userMod().setEmail("dmitriykulinich" + (new Date()).getTime() + "@maildrop.ropot.net");
	app().userMod().setGenger("male");
	app().userMod().setPassword("asdasd123");
	app().userMod().setLocation("Dnipropetrovsk,+49000");
	app().userMod().setSexualOrientation("hetero");
	Boolean termsConsent = true;
	Boolean policyConsent = true;
	String lid = "3830403ea31a11e9a8911402ec33333c";
	String landingVisitId = "4361e4417c576200f02c81c7ecc54eab";
	String transferId = "b106b41c55f449ae84e2d050b981bed9";
	System.out.println("email - "+app().userMod().getEmail());

	ValidatableResponse response = app().rest()
			.request()
			.body("UserForm[gender]=" + app().userMod().getGender()
					+ "&UserForm[sexual_orientation]=" + app().userMod().getSexualOrientation()
					+ "&UserForm[age]=" + app().userMod().getAge()
					+ "&UserForm[location]=" + app().userMod().getLocation()
					+ "&UserForm[email]=" + app().userMod().getEmail()
					+ "&UserForm[password]=" + app().userMod().getPassword()
					+ "&UserForm[termsConsent]=" + termsConsent
					+ "&UserForm[policyConsent]=" + policyConsent
					+ "&UserForm[lid]=" + lid
					+ "&UserForm[landingVisitId]=" + landingVisitId
					+ "&UserForm[transferId]=" + transferId)
			.when()
			.post("https://www.flirt.com/user/register")
			.then()
			.statusCode(302)
			.header("location", Matchers.equalTo("https://www.flirt.com/confirmation"));
    }
}