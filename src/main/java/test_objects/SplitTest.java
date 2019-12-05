package test_objects;

import core.helpers.ProxyHelper;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import static core.ApplicationManager.app;
import static core.ApplicationManager.app;

public class SplitTest {

    public static void main(String[] args) throws IOException {
	String baseUrl = "https://m.seksverlangen.be/ppc.php?dynamicpage=all_mlp_mst_jumplp_t_v3";
	String cookieName = "7bd0ed41034abdc0021d05d1c84eacf1"; // Ежедневно обновляется в админке, без него прокся не пашет
	String splitId1 = "9cd89acdad2011e896341402ec33333c";
	String splitId2 = "754f3b0d15a711eab997e4115bd61ad4";
	int id1 = 0;
	int id2 = 0;

	for (int i = 0; i < 1; i++) {
	    Response response = app().rest().request()
			    .header("X-Requested-With", "XMLHttpRequest")
			    .cookie(cookieName, app().proxy().getIp("bel"))
			    .when()
			    .get(baseUrl)
			    .then()
			    .statusCode(200)
			    .extract()
			    .response();

	    Document doc = Jsoup.parse(response.asString());
	    Element className = doc.getElementById("base-form");
	    String nameLid = className.getElementsByAttributeValue("name", "UserForm[lid]").val();
	    if (nameLid.isEmpty()) {
		nameLid = className.getElementsByAttributeValue("name", "lid").val();
	    }
	    if (nameLid.equals(splitId1)) {
		id1++;
	    } else if (nameLid.equals(splitId2)) {
		id2++;
	    }
	}
	System.out.println("Total visits to first page " + id1);
	System.out.println("Total visits to second page " + id2);
	System.out.println("Total visits to page " + splitId1 + " - " + id1);
	System.out.println("Total visits to second page " + splitId2 + " - " + id2);

    }
}