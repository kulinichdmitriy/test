package test_objects;

import core.helpers.ProxyHelper;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static core.ApplicationManager.app;

public class SplitTest {

    public static void main(String[] args) throws IOException {

	String baseUrl = "https://m.flirt.com/ddc.php?dynamicpage=all_mlp_5st_memb_t";
	String cookieName = "d40995ea3c849b7b373da2e345e0fd4b";
	ProxyHelper proxyHelper = new ProxyHelper();

	Response response = app().rest().request()
			.header("X-Requested-With", "XMLHttpRequest").cookie(cookieName, proxyHelper.getProxyIp("fra"))
			.when()
			.get(baseUrl)
			.then()
			.statusCode(200)
			.extract()
			.response();

	Document doc = Jsoup.connect(baseUrl).get();
	Element className = doc.getElementById("base-form");
	Elements sukaBlatTvar = className.getElementsByAttributeValue("name", "UserForm[lid]");
	System.out.println("------------------ " + sukaBlatTvar);
    }
}
