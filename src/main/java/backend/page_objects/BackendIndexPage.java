package backend.page_objects;

import core.config.Config;
import org.hamcrest.Matchers;
import org.testng.TestException;

import static core.ApplicationManager.app;

public class BackendIndexPage {
    /**
     * Authentication to Backend
     *
     * @return true or false
     */
    public boolean auth() {
	try {
	    app().rest().request()
			    .auth().preemptive().basic(Config.access().getProperty("phoenix.login"), Config.access().getProperty("phoenix.password"))
			    .when()
			    .get(Config.project().getProperty("phoenix.url.login"))
			    .then()
			    .statusCode(302)
			    .header("location", Matchers.equalTo(Config.project().getProperty("phoenix.url.base")));
	    return true;
	} catch (AssertionError ex) {
	    String message = ex.getMessage();

	    if (message.contains("401")) {
		throw new TestException("Unable to do Backend Basic auth using userName ["
				+ Config.access().getProperty("phoenix.login") + "]: " + ex);
	    } else if (message.contains("200")) {
		throw new TestException("Unable to login Backend using userName ["
				+ Config.access().getProperty("phoenix.login") + "]: " + ex);
	    } else if (message.contains("500") || message.contains("502")) {
		app().log().warning("Unable to login Backend");
	    } else {
		throw new TestException("Unable to login Backend: " + ex);
	    }
	    return false;
	}
    }
}
