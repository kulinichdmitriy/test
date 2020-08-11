package core.helpers;

import org.testng.TestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlHelper {
    /**
     * Encode URL JSON
     * @param url
     * @return String formatted URL
     */
    public static String urlEncoderJson(String url) {
	try {
	    return URLEncoder.encode(url, "UTF-8").replace("%28", "(").replace("%29", ")").replace("%27", "'");
	} catch (UnsupportedEncodingException ex) {
	    throw new TestException("Unsupported encoding: " + ex);
	}
    }
}
