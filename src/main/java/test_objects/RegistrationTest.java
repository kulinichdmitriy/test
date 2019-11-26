package test_objects;

import core.helpers.ProxyHelper;
import io.restassured.response.Response;
import org.testng.TestException;

import java.util.Date;

import static core.ApplicationManager.app;

public class RegistrationTest {

    public void registration(String gender) {
	ProxyHelper proxyHelper = new ProxyHelper();

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
	String cookieName = "258a2738194f8ba6c3f6203326e0ec1c";

	Response response = app().rest().request()
			.header("X-Requested-With", "XMLHttpRequest").cookie(cookieName, proxyHelper.getProxyIp("fra"))
			.body("UserForm[gender]=" + gender
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

	System.out.println("------------- " + app().userModel().getEmail());
	String refreshToken = response.jsonPath().get("data.refresh_token");
	String status = response.jsonPath().get("status");

	if (!status.equals("success")) {
	    throw new TestException("Registration failed, " + response.jsonPath().get("$"));
	}
	app().userModel().setAutologinKey(refreshToken);
    }

    public void confirmation() {
	// Make autologin
	app().rest().request()
			.when()
			.get("https://www.flirt.com/site/autologin/key/" + app().userModel().getAutologinKey())
			.then()
			.statusCode(200);
	app().log().info("AutologinKey - " + app().userModel().getAutologinKey());
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
    }
}