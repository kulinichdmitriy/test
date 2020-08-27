package backend.page_objects;

import core.data_models.UserModel;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.TestException;

import java.util.HashMap;
import java.util.Map;

import static core.ApplicationManager.app;

public class BackendSearchPage {

    public String getUserInfo(String email, String param) {

        BackendIndexPage auth = new BackendIndexPage();
        auth.auth();

            Response response = app().rest().request().body("CSRF_TOKEN=&FindUserForm[user]="+email+"&yt0=&FindUserForm[findByMultiProfileId]=0&FindUserForm[ccf]=")
                    .post("https://my.platformphoenix.com/admin/user/find")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

            Map<String, String> userData = new HashMap<>();

            try {
                Document doc = Jsoup.parse(response.asString());
                Element table = doc.getElementById("yw3");
                Elements rows = table.children().first().children();
                for (Element row : rows) {
                    userData.put(row.children().get(0).text().replace(":", ""), row.children().get(1).text());
                }

                return userData.get(param);
            }
             catch (Exception ex) {
            throw new TestException("Unable to parse User info table: "
                    + this.getClass().getName() + " " + ex);
        }
    }
}

