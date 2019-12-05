package backend.page_objects;

import com.google.common.base.Strings;
import core.config.Config;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.TestException;

import static core.ApplicationManager.app;

public class BackendSiteIpCookiePage {

    public String getIpCookieName() {
	BackendIndexPage indexPage = new BackendIndexPage();
	indexPage.auth();

	String ipCookieName = "";

	Response response = app().rest().request()
			.get(Config.project().getProperty("phoenix.url.site.ip_cookie"))
			.then()
			.statusCode(200)
			.extract()
			.response();

	try {
	    Document doc = Jsoup.parse(response.asString());
	    ipCookieName = doc.getElementsByClass("span10")
			    .get(0)
			    .getElementsByTag("span")
			    .text();
	} catch (Exception ex) {
	    throw new TestException(this.getClass().getName() + " Unable to parse ip cookie name");
	}

	if (Strings.isNullOrEmpty(ipCookieName)) {
	    throw new TestException(this.getClass().getName() + " Unable to get ip cookie name");
	}
	return ipCookieName;
    }
}
