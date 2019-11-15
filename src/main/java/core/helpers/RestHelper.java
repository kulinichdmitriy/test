package core.helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestHelper {
    CookieFilter cookieFilter;
    private RequestSpecification baseSpecification;

    public RestHelper() {
	baseSpecification = new RequestSpecBuilder()
			.addFilter(ResponseLoggingFilter.logResponseTo(LoggerHelper.getLogStream(), LogDetail.STATUS))
			.addFilter(RequestLoggingFilter.logRequestTo(LoggerHelper.getLogStream()))
			.addFilter(ErrorLoggingFilter.logErrorsTo(LoggerHelper.getLogStream()))
			.setContentType(ContentType.URLENC.withCharset("UTF-8"))
			.setAccept(ContentType.ANY)
			.setRelaxedHTTPSValidation()
			.setUrlEncodingEnabled(true)
			.build();
    }

    public RequestSpecification request() {
	return given().spec(baseSpecification)
			.filter(this.getCookie());
    }

    private CookieFilter getCookie() {
	if (cookieFilter == null) {
	    cookieFilter = new CookieFilter();
	}
	return cookieFilter;
    }

    public void clearCookie() {
	cookieFilter = null;
    }
}
