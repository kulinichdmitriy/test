package core.helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestHelper {
    private RequestSpecification baseSpecification;

    public RestHelper() {
	baseSpecification = new RequestSpecBuilder()
			.addFilter(new CookieFilter())
			.setContentType(ContentType.URLENC)
			.setAccept(ContentType.ANY)
			.setRelaxedHTTPSValidation()
			.setUrlEncodingEnabled(true)
			.build();
    }

    public RequestSpecification request() {
	return given().spec(baseSpecification);
    }
}