package test_objects;

import backend.page_objects.BackendSiteIpCookiePage;
import core.data_models.UserModel;
import data_providers.RegistrationDataProvider;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.TestException;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import static core.ApplicationManager.app;

public class RegistrationTest {

    public void registration(UserModel userModel) {

	Boolean termsConsent = true;
	Boolean policyConsent = true;
	String lid = "3830403ea31a11e9a8911402ec33333c";
	String landingVisitId = "4361e4417c576200f02c81c7ecc54eab";
	String transferId = "b106b41c55f449ae84e2d050b981bed9";

	BackendSiteIpCookiePage ipCookiePage = new BackendSiteIpCookiePage();
	String ipCookieName = ipCookiePage.getIpCookieName();
	String country = "can";
	app().userModel().setLocation(this.getLocationFromIndex(ipCookieName, country));

	Response response = app().rest().request()
			.header("X-Requested-With", "XMLHttpRequest")
			.cookie(ipCookieName, app().proxy().getIp(country))
			.body("UserForm[gender]=" + userModel.getGender()
					+ "&UserForm[sexual_orientation]=" + userModel.getSexualOrientation()
					+ "&UserForm[age]=" + userModel.getAge()
					+ "&UserForm[location]=" + app().userModel().getLocation()
					+ "&UserForm[email]=" + userModel.getEmail()
					+ "&UserForm[password]=" + userModel.getPassword()
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

    public void confirmation() {
	// Make autologin
	app().rest().request()
			.when()
			.get("https://www.flirt.com/site/autologin/key/" + app().userModel().getAutologinKey())
			.then()
			.statusCode(302);
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

    /**
     * Get location from index page
     *
     * @return String location
     */
    private String getLocationFromIndex(String ipCookieName, String country) {
	Response response = app().rest().request()
			.cookie(ipCookieName, app().proxy().getIp(country))
			.when()
			.get("https://www.benaughty.com")
			.then()
			.statusCode(200)
			.extract()
			.response();

	String location = "";
	Elements userForms;

	try {
	    Document doc = Jsoup.parse(response.asString());
	    doc.outputSettings().charset("UTF-8");
	    userForms = doc.getElementsByAttributeValueMatching("name", "location");
	} catch (Exception ex) {
	    throw new TestException(this.getClass().getName() + " Unable to get location from index: " + ex);
	}

	for (Element form : userForms) {
	    location = form.attr("value");
	    if (!Strings.isNullOrEmpty(location)) {
		break;
	    }
	}

	if (location.isEmpty()) {
	    app().log().error("Index page field location is empty!");
	    return "London";
	}
	return location;
    }
}
