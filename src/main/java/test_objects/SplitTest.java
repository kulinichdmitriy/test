package test_objects;

import backend.page_objects.BackendIndexPage;
import core.config.Config;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static core.ApplicationManager.app;

public class SplitTest {

    public void SplitTest(String pageName, String trafficSource, String country, String siteName,String padeId1,String padeId2) {
	String splitUrl = "https://m."+siteName+"/" + trafficSource + ".php?dynamicpage=" + pageName;
	String cookieName = Config.project().getProperty("phoenix.url.site.ip_cookie");
	padeId1 = "9cd89acdad2011e896341402ec33333c";
	padeId2 = "754f3b0d15a711eab997e4115bd61ad4";
	int id1 = 0;
	int id2 = 0;

	/*
	Login to phoenix for take cookie
	 */

	BackendIndexPage login = new BackendIndexPage();
	login.auth();
	/*
	Go to split page
 	*/
	for (int i = 0; i < 10; i++) {
	    Response response = app().rest().request()
			    .header("X-Requested-With", "XMLHttpRequest")
			    .cookie(cookieName, app().proxy().getIp(country))
			    .when()
			    .get(splitUrl)
			    .then()
			    .statusCode(200)
			    .extract()
			    .response();

	   /*
	    Search lid on page
	     */
	    Document doc = Jsoup.parse(response.asString());
	    Element className = doc.getElementById("base-form");
	    String nameLid = className.getElementsByAttributeValue("name", "UserForm[lid]").val();


	    if (nameLid.isEmpty()) {
		nameLid = className.getElementsByAttributeValue("name", "lid").val();
	    }
	    if (nameLid.equals(padeId1)) {
		id1++;
	    } else if (nameLid.equals(padeId2)) {
		id2++;
	    }
	}
	System.out.println("Total visits to first page " + id1);
	System.out.println("Total visits to second page " + id2);
	System.out.println("Total visits to page " + padeId1 + " - " + id1);
	System.out.println("Total visits to second page " + padeId2 + " - " + id2);

    }
}