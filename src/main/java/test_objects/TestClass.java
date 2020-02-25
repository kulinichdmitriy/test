package test_objects;

import backend.page_objects.BackendIndexPage;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.ApplicationManager.app;

public class TestClass {

    public static void main(String[] args) {
	String splitId = "f65c341abe4379d961c4037b1dcb4e54";

	BackendIndexPage login = new BackendIndexPage();
	login.auth();

	TestClass splitPage = new TestClass();
	Map<String, String> splitData = splitPage.getSplitData(splitId);
	String[] array = splitData.get("variations").split(",");
	List<String> variations = Arrays.asList(array);

	Map<String, String> pageData = splitPage.getPageData(variations);

	pageData.forEach((k, v) -> System.out.println(k + " => " + v));
    }

    /**
     * Get split data by splitId
     *
     * @param splitId
     * @return Map<String ,   String> splitDat
     */
    public Map<String, String> getSplitData(String splitId) {
	Response response = app().rest()
			.request()
			.header("X-Requested-With", "XMLHttpRequest")
			.when()
			.get("https://my.platformphoenix.com/landing/splitList")
			.then()
			.statusCode(200)
			.extract()
			.response();

	Map<String, String> splitData = response.jsonPath().get("activeDataProvider.rawData.find{it.splitId=='" + splitId + "'}");
	return splitData;
    }

    /**
     * Get page data by variations
     *
     * @param variations
     * @return Map<String ,   String> pageData
     */
    public Map<String, String> getPageData(List<String> variations) {
	Response response = app().rest()
			.request()
			.header("X-Requested-With", "XMLHttpRequest")
			.when()
			.get("https://my.platformphoenix.com/landing/pageList")
			.then()
			.statusCode(200)
			.extract()
			.response();

	Map<String, String> pageData = new HashMap<>();

	for (String pageName : variations) {
	    Map<String, String> data = response.jsonPath().get("activeDataProvider.rawData.find{it.name=='" + pageName + "'}");
	    String landingId = data.get("landingId");

	    if (landingId.isEmpty()) {
		app().log().error("Unable to get landingId by pageName [" + pageName + "]");
		continue;
	    }
	    pageData.put(pageName, landingId);
	}
	return pageData;
    }
}
