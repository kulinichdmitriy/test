package test_objects;

import backend.page_objects.BackendIndexPage;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;

import static core.ApplicationManager.app;

public class TestClass {

    public static void main(String[] args) {

	String splitPageName = "all_mlp_5st_downshift_a";

	BackendIndexPage login = new BackendIndexPage();
	login.auth();
	Response response = app().rest()
			.request()
			.header("X-Requested-With", "XMLHttpRequest")
			.body("application\\modules\\admin\\models\\LandingSplitFiltersForm[status]: on")
			.when()
			.get("https://my.platformphoenix.com/landing/splitList")
			.then()
			.statusCode(200)
			.extract()
			.response();

	String id = "bfd3ce40308a2631de076ec558201472";
	Map<String, String> mass = response.jsonPath().get("activeDataProvider.rawData.find{it.splitId=='" + id + "'}");
	/*
	Get lid
	 */
	String variations = mass.get("variations");
	String[] pageName = variations.split(",");
	String page1 = pageName[0];
	String page2 = pageName[1];

	Response getLid = app().rest()
			.request()
			.header("X-Requested-With", "XMLHttpRequest")
			.body("ArrayProviderLandingFilterForm[name]:"+page1+"")
			.when()
			.get("https://my.platformphoenix.com/landing/pageList")
			.then()
			.statusCode(200)
			.extract()
			.response();


	Document doc = Jsoup.parse(getLid.toString());
	System.out.println(doc);


	String countryGeo = mass.get("countryGeo");

	String percentage = mass.get("percentage");
	String utm_source = mass.get("utm_source");
	String siteName = "flirt.com";

	//SplitTest splitTest = new SplitTest();
	//splitTest.SplitTest(splitPageName, utm_source, countryGeo, siteName, page1, page2);

    }
}
