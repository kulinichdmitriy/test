package test_objects;

import backend.page_objects.BackendSiteIpCookiePage;
import core.data_models.UserModel;
import core.helpers.UrlHelper;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.TestException;
import org.testng.util.Strings;

import static core.ApplicationManager.app;

public class RegistrationTest {

    public Cookie getCookie() {
        BackendSiteIpCookiePage ipCookiePage = new BackendSiteIpCookiePage();
        String ipCookieName = ipCookiePage.getIpCookieName();
        String country = "can";
        String location = app().proxy().getIp(country);
        return new Cookie.Builder(ipCookieName, location).build();
    }

    public void registration(UserModel userModel) {

        Boolean termsConsent = true;
        Boolean policyConsent = true;
        String lid = "3830403ea31a11e9a8911402ec33333c";
        String landingVisitId = "4361e4417c576200f02c81c7ecc54eab";
        String transferId = "b106b41c55f449ae84e2d050b981bed9";

        Response response = app().rest().request()
                .header("X-Requested-With", "XMLHttpRequest")
                .cookie(getCookie())
                .body("UserForm[gender]=" + userModel.getGender()
                        + "&UserForm[sexual_orientation]=" + userModel.getSexualOrientation()
                        + "&UserForm[age]=" + userModel.getAge()
                        + "&UserForm[location]=" + getLocationFromIndex()
                        + "&UserForm[email]=" + userModel.getEmail()
                        + "&UserForm[password]=" + userModel.getPassword()
                        + "&UserForm[termsConsent]=" + termsConsent
                        + "&UserForm[policyConsent]=" + policyConsent
                        + "&UserForm[lid]=" + lid
                        + "&UserForm[landingVisitId]=" + landingVisitId
                        + "&UserForm[transferId]=" + transferId)
                .when()
                .post("https://www.flirt.com/user/register")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String refreshToken = response.jsonPath().get("data.refresh_token");
        String status = response.jsonPath().get("status");

        if (!status.equals("success")) {
            throw new TestException("Registration failed, " + response.jsonPath().get("$"));
        }
        app().userModel().setAutologinKey(refreshToken);
    }

    public void funnel() {
        String token = app().userModel().getCsrfToken();
        String data = "{\"scenario\":\"funnel\",\"userAttributes\":{\"chatUpLine\":\"My+info+text\",\"first_name\":\"\",\"gender\":\"male\",\"tribe\":[\"0\"],"
                + "\"genderIdentity\":\"0\",\"birthdayDate\":{\"year\":2000,\"month\":8,\"day\":11},\"marital_status\":\"0\",\"professionId\":\"0\",\"build\":\"0\","
                + "\"hair_color\":\"0\",\"registrationReason\":\"0\",\"race\":\"0\",\"islam_cult\":\"0\",\"religious_values\":\"0\",\"eating_habits\":\"0\","
                + "\"muslim_born\":\"0\",\"religious_services\":\"0\",\"read_quran\":\"0\",\"net_worth\":\"0\",\"income\":\"0\",\"moneyRole\":\"0\","
                + "\"hijab_wearing\":\"0\",\"zodiacSign\":\"0\",\"bloodType\":\"0\",\"looking_for\":{\"1\":0,\"2\":0,\"3\":0,\"4\":0,\"5\":0,\"6\":0},\"hobby\":{\"1\":0,"
                + "\"2\":0,\"3\":0,\"4\":0,\"5\":0,\"6\":0,\"7\":0,\"8\":0,\"9\":0,\"10\":0,\"11\":0,\"12\":0,\"13\":0,\"14\":0,\"15\":0},\"screenname\":\"Kevin2323\","
                + "\"foreignComm\":null},\"defaultSearchParams\":{\"photo_count\":{\"from\":\"1\"},\"photoLevel\":[\"0\"],\"age\":{\"from\":\"18\",\"to\":\"25\"},"
                + "\"country\":\"CAN\",\"location\":{\"distance\":\"50\",\"latitude\":\"43.2855\",\"longitude\":\"-80.4508\"},\"gender\":\"2\","
                + "\"sexual_orientation\":[\"hetero\"],\"ageFrom\":\"18\",\"ageTo\":\"25\",\"distance\":\"50\",\"locationInput\":\"Ayr,+ON,+N0B+0B7\"},"
                + "\"labels\":{\"race\":[\"Not+Given\",\"Caucasian\",\"Asian\",\"Black/+African\",\"Native+American\",\"Latino/+Hispanic\",\"Middle+Eastern\",\"Mixed/+Other\",\"Rather+not+say\"],\"marital_status\":{\"0\":\"Not+Given\",\"1\":\"Single\",\"4\":\"Divorced\",\"5\":\"Widowed\",\"6\":\"Rather+not+say\",\"7\":\"Separated\"},\"professionId\":[\"Not+Given\",\"Other+profession+/+Prefer+not+to+say\",\"Medical+/+Dental+Doctor\",\"Medical+Assistant+/+Technician\",\"Nurse\",\"Scientist+/+Researcher\",\"Army\",\"Navy\",\"Air+Force\",\"Pilot\",\"Air+Crew\",\"Police+/+Sheriff+/+Corrections+Officer\",\"Fire+Fighter\",\"Security+Guards\"],\"build\":{\"0\":\"Not+Given\",\"2\":\"Slim\",\"3\":\"Medium\",\"4\":\"Ample\",\"5\":\"Athletic\",\"6\":\"Big+&+Beautiful\",\"7\":\"Rather+not+say\"},\"hair_color\":{\"0\":\"Not+Given\",\"1\":\"Black\",\"4\":\"Red\",\"5\":\"Blond\",\"6\":\"White\",\"7\":\"Other\",\"8\":\"Shaven/+Bald\",\"9\":\"Brown\",\"10\":\"Rather+not+say\"},\"religion\":[\"Not+Given\",\"Christian\",\"Muslim\",\"Buddhist\",\"Hindu\",\"Sikh\",\"Jewish\",\"Other\",\"Atheist\",\"Agnostic\",\"Catholic\",\"Rather+not+say\"],\"gender\":{\"1\":\"a+man\",\"2\":\"a+woman\"},\"tribe\":[\"Not+Given\",\"Bear\",\"Clean-Cut\",\"Geek\",\"Twink\",\"Daddy\",\"Jock\",\"BDSM\"],\"distance\":{\"20\":\"20\",\"50\":\"50\",\"100\":\"100\"},\"islam_cult\":[\"Not+Given\",\"Islam+-+Sunni\",\"Islam+-+Shiite\",\"Islam+-+Sufism\",\"Islam+-+Ahmadiyya\",\"Islam+-+Other\",\"Willing+to+revert\",\"Other\"],\"religious_values\":[\"Not+Given\",\"Very+Religious\",\"Religious\",\"Not+Religious\"],\"eating_habits\":[\"Not+Given\",\"Halal+foods+always\",\"Halal+foods+when+I+can\",\"No+special+restrictions\"],\"muslim_born\":[\"Not+Given\",\"Born+a+muslim\",\"Reverted+to+Islam\",\"Plan+to+revert+to+Islam\"],\"religious_services\":[\"Not+Given\",\"Daily\",\"Only+on+Jummah+/+Fridays\",\"Sometimes\",\"Only+During+Ramadan\",\"Never\"],\"read_quran\":[\"Not+Given\",\"Daily\",\"Ocassionally\",\"Only+During+Ramadan\",\"Only+on+Jummah+/+Fridays\",\"Read+translated+version\",\"Never+Read\",\"Prefer+not+to+say\"],\"hijab_wearing\":[\"Not+Given\",\"Yes\",\"Sometimes\",\"No\"],\"net_worth\":[\"Not+Given\",\"$250,000\",\"$500,000\",\"$1+million\",\"$2+million\",\"$5+million\",\"$10+million\",\"$50+million\",\"$100+million\",\"More+than+$100+million\"],\"income\":{\"0\":\"Not+Given\",\"1\":\"Low\",\"2\":\"Average\",\"3\":\"Well+paid\",\"4\":\"Can+afford+anything\",\"7\":\"Rather+not+say\"},\"moneyRole\":[\"Not+Given\",\"Sugarbabby\",\"Sugardaddy\",\"Sugarmommy\"],\"zodiacSign\":[\"Not+Given\",\"Aries\",\"Taurus\",\"Gemini\",\"Cancer\",\"Leo\",\"Virgo\",\"Libra\",\"Scorpio\",\"Sagittarius\",\"Capricorn\",\"Aquarius\",\"Pisces\",\"Rather+not+say\"],\"bloodType\":[\"Not+Given\",\"0\",\"A\",\"B\",\"AB\",\"Rather+not+say\"],\"looking_for\":{\"1\":\"Friendship\",\"2\":\"Email+or+Chat\",\"3\":\"Relationship\",\"4\":\"Fun\",\"5\":\"Other\",\"6\":\"Tell+you+later\"},\"hobby\":{\"1\":\"Watching/playing+Sports\",\"2\":\"Listening+to+music\",\"3\":\"Karaoke+and+Band\",\"4\":\"Cooking/Gourmet\",\"5\":\"Shopping/Fashion\",\"6\":\"Outdoor+activity\",\"7\":\"Car/Bike\",\"8\":\"Language+study\",\"9\":\"Reading+manga/books\",\"10\":\"Watching+TV/films/serials\",\"11\":\"Games\",\"12\":\"Internet\",\"13\":\"Pets\",\"14\":\"Health/Fitness\",\"15\":\"Other\"},\"occupation\":[\"Not+Given\",\"Banking/financial+services\",\"Charity\",\"Consultancy/analysis\",\"Education\",\"Healthcare\",\"IT/Computing\",\"Legal/professional\",\"Leisure/hotels/catering\",\"Manufacturing/engineering\",\"Media/advertising/PR\",\"Public+sector/armed+forces\",\"Retail/wholesale+trade\",\"Skilled/unskilled+trade\",\"Telecommunications/utilities\",\"Other\"],\"hidePhotoLevel\":[],\"iceBreaker\":\"I+want+to+activate+'Promote+my+account'+and+use+my+'Status'+as+a+promotion+message\",\"iceBreakerInfo\":\"With+our+'Promote+my+account'+feature+you+will+meet+new+matches+easily+even+when+you+are+offline!+We+will+send+promotional+messages,+wink+at+your+potential+matches+and+add+them+to+your+friends+list+on+your+behalf+to+increase+your+chances+to+meet+someone+special.\"},\"funnelProperties\":{\"showFirstStep\":true,\"showSecondStep\":false,\"isScreennameEditable\":true},\"formParams\":{\"height\":[\"Not+Given\",\"4'+0\\\"+(1.22m)\",\"4'+1\\\"+(1.24m)\",\"4'+2\\\"+(1.27m)\",\"4'+3\\\"+(1.30m)\",\"4'+4\\\"+(1.32m)\",\"4'+5\\\"+(1.35m)\",\"4'+6\\\"+(1.37m)\",\"4'+7\\\"+(1.40m)\",\"4'+8\\\"+(1.42m)\",\"4'+9\\\"+(1.45m)\",\"4'+10\\\"+(1.47m)\",\"4'+11\\\"+(1.50m)\",\"5'+0\\\"+(1.52m)\",\"5'+1\\\"+(1.55m)\",\"5'+2\\\"+(1.57m)\",\"5'+3\\\"+(1.60m)\",\"5'+4\\\"+(1.63m)\",\"5'+5\\\"+(1.65m)\",\"5'+6\\\"+(1.68m)\",\"5'+7\\\"+(1.70m)\",\"5'+8\\\"+(1.73m)\",\"5'+9\\\"+(1.75m)\",\"5'+10\\\"+(1.78m)\",\"5'+11\\\"+(1.80m)\",\"6'+0\\\"+(1.83m)\",\"6'+1\\\"+(1.85m)\",\"6'+2\\\"+(1.88m)\",\"6'+3\\\"+(1.91m)\",\"6'+4\\\"+(1.93m)\",\"6'+5\\\"+(1.96m)\",\"6'+6\\\"+(1.98m)\",\"6'+7\\\"+(2.01m)\",\"6'+8\\\"+(2.03m)\",\"6'+9\\\"+(2.06m)\",\"6'+10\\\"+(2.08m)\",\"6'+11\\\"+(2.11m)\",\"7'+0\\\"+(2.13m)\",\"Rather+not+say\"],\"weight\":[\"Not+Given\",\"6st+6lb+-+41kg\",\"6st+8lb+-+42kg\",\"6st+10lb+-+43kg\",\"6st+12lb+-+44kg\",\"7st+1lb+-+45kg\",\"7st+3lb+-+46kg\",\"7st+5lb+-+47kg\",\"7st+7lb+-+48kg\",\"7st+9lb+-+49kg\",\"7st+12lb+-+50kg\",\"8st+0lb+-+51kg\",\"8st+2lb+-+52kg\",\"8st+4lb+-+53kg\",\"8st+6lb+-+54kg\",\"8st+9lb+-+55kg\",\"8st+11lb+-+56kg\",\"8st+13lb+-+57kg\",\"9st+1lb+-+58kg\",\"9st+3lb+-+59kg\",\"9st+6lb+-+60kg\",\"9st+8lb+-+61kg\",\"9st+10lb+-+62kg\",\"9st+12lb+-+63kg\",\"10st+0lb+-+64kg\",\"10st+3lb+-+65kg\",\"10st+5lb+-+66kg\",\"10st+7lb+-+67kg\",\"10st+9lb+-+68kg\",\"10st+11lb+-+69kg\",\"11st+0lb+-+70kg\",\"11st+2lb+-+71kg\",\"11st+4lb+-+72kg\",\"11st+6lb+-+73kg\",\"11st+8lb+-+74kg\",\"11st+11lb+-+75kg\",\"11st+13lb+-+76kg\",\"12st+1lb+-+77kg\",\"12st+3lb+-+78kg\",\"12st+5lb+-+79kg\",\"12st+8lb+-+80kg\",\"12st+10lb+-+81kg\",\"12st+12lb+-+82kg\",\"13st+0lb+-+83kg\",\"13st+2lb+-+84kg\",\"13st+5lb+-+85kg\",\"13st+7lb+-+86kg\",\"13st+9lb+-+87kg\",\"13st+11lb+-+88kg\",\"13st+13lb+-+89kg\",\"14st+2lb+-+90kg\",\"14st+4lb+-+91kg\",\"14st+6lb+-+92kg\",\"14st+8lb+-+93kg\",\"14st+10lb+-+94kg\",\"14st+13lb+-+95kg\",\"15st+1lb+-+96kg\",\"15st+3lb+-+97kg\",\"15st+5lb+-+98kg\",\"15st+7lb+-+99kg\",\"15st+10lb+-+100kg\",\"15st+12lb+-+101kg\",\"16st+0lb+-+102kg\",\"16st+2lb+-+103kg\",\"16st+4lb+-+104kg\",\"16st+7lb+-+105kg\",\"16st+9lb+-+106kg\",\"16st+11lb+-+107kg\",\"16st+13lb+-+108kg\",\"17st+1lb+-+109kg\",\"17st+4lb+-+110kg\",\"17st+6lb+-+111kg\",\"17st+8lb+-+112kg\",\"17st+10lb+-+113kg\",\"17st+12lb+-+114kg\",\"18st+1lb+-+115kg\",\"18st+3lb+-+116kg\",\"18st+5lb+-+117kg\",\"18st+7lb+-+118kg\",\"18st+9lb+-+119kg\",\"18st+12lb+-+120kg\",\"19st+0lb+-+121kg\",\"19st+2lb+-+122kg\",\"19st+4lb+-+123kg\",\"19st+6lb+-+124kg\",\"19st+9lb+-+125kg\",\"19st+11lb+-+126kg\",\"19st+13lb+-+127kg\",\"20st+1lb+-+128kg\",\"20st+3lb+-+129kg\",\"20st+6lb+-+130kg\",\"20st+8lb+-+131kg\",\"20st+10lb+-+132kg\",\"20st+12lb+-+133kg\",\"21st+0lb+-+134kg\",\"21st+3lb+-+135kg\",\"21st+5lb+-+136kg\",\"21st+7lb+-+137kg\",\"21st+9lb+-+138kg\",\"21st+11lb+-+139kg\",\"Rather+not+say\"],\"marital_status\":{\"0\":\"Not+Given\",\"1\":\"Single\",\"4\":\"Divorced\",\"5\":\"Widowed\",\"6\":\"Rather+not+say\",\"7\":\"Separated\"},\"build\":{\"0\":\"Not+Given\",\"2\":\"Slim\",\"3\":\"Medium\",\"4\":\"Ample\",\"5\":\"Athletic\",\"6\":\"Big+&+Beautiful\",\"7\":\"Rather+not+say\"},\"hair_color\":{\"0\":\"Not+Given\",\"1\":\"Black\",\"4\":\"Red\",\"5\":\"Blond\",\"6\":\"White\",\"7\":\"Other\",\"8\":\"Shaven/+Bald\",\"9\":\"Brown\",\"10\":\"Rather+not+say\"},\"nativeLanguage\":[\"Not+Given\",\"Russian\",\"Spanish\",\"Italian\",\"Chinese\",\"German\",\"Turkish\",\"French\",\"Japanese\",\"English\",\"Greek\",\"Ukrainian\"],\"secondLanguage\":[\"Not+Given\",\"Russian\",\"Spanish\",\"Italian\",\"Chinese\",\"German\",\"Turkish\",\"French\",\"Japanese\",\"English\",\"Greek\",\"Ukrainian\"],\"education\":{\"0\":\"Not+Given\",\"1\":\"High+school\",\"2\":\"Some+college\",\"8\":\"Still+studying\",\"9\":\"Bachelor's+degree\",\"10\":\"Master's+degree/+Doctorate\",\"11\":\"No+degree\",\"12\":\"Rather+not+say\"},\"race\":[\"Not+Given\",\"Caucasian\",\"Asian\",\"Black/+African\",\"Native+American\",\"Latino/+Hispanic\",\"Middle+Eastern\",\"Mixed/+Other\",\"Rather+not+say\"],\"religion\":[\"Not+Given\",\"Christian\",\"Muslim\",\"Buddhist\",\"Hindu\",\"Sikh\",\"Jewish\",\"Other\",\"Atheist\",\"Agnostic\",\"Catholic\",\"Rather+not+say\"],\"drink\":{\"0\":\"Not+Given\",\"1\":\"No\",\"3\":\"Yes,+socially\",\"4\":\"Yes,+regularly\",\"5\":\"Rather+not+say\"},\"smoke\":[\"Not+Given\",\"No\",\"Yes,+regularly\",\"Yes,+socially\",\"Rather+not+say\"],\"englishLevel\":[\"Not+Given\",\"Beginner\",\"Elementary\",\"Pre-Intermediate\",\"Intermediate\",\"Upper+Intermediate\",\"Advanced\",\"Proficient\"],\"interest\":{\"1\":\"Art\",\"2\":\"Travel\",\"3\":\"Tech\",\"4\":\"Fashion\",\"5\":\"Music\",\"6\":\"Food\",\"7\":\"Sports\",\"8\":\"Spirituality\",\"9\":\"The+Outdoors\",\"10\":\"Watching+Sports\",\"11\":\"Watching+TV\",\"12\":\"Movies\",\"13\":\"Theatre\",\"14\":\"Reading\",\"15\":\"Dancing\",\"16\":\"Singing\",\"17\":\"Pubs\",\"18\":\"Clubs\",\"19\":\"Cooking\",\"20\":\"Restaurants\",\"21\":\"Gardening\",\"22\":\"Cars\",\"23\":\"Yoga\",\"24\":\"Writing\",\"25\":\"Love\",\"26\":\"Relaxing\",\"27\":\"Hiking\",\"28\":\"Kayaking\",\"29\":\"Fishing\",\"30\":\"Career\",\"31\":\"Religion\",\"32\":\"Photography\",\"33\":\"Camping\",\"34\":\"Business+Networking\",\"35\":\"Meditation\"},\"industry\":[\"Not+Given\",\"Tech\",\"Education\",\"Entertainment+&+Media\",\"Financial+Services\",\"Health\",\"Hospitality+&+Leisure\",\"Fashion\",\"Art\",\"Retail\",\"Real+Estate\",\"Architecture\",\"Advertising\",\"Marketing\",\"Design\",\"IT\",\"Other\"],\"careerLevel\":[\"careerLevel::-+Not+Given+-\",\"careerLevel::Senior+Professional+Level\",\"careerLevel::Mid-Level+Management\",\"careerLevel::Executive\",\"careerLevel::Senior-Level+Management\",\"careerLevel::Other\"],\"favorite_sexual_position\":{\"1\":\"Doggy+Style+\",\"2\":\"Missionary+\",\"3\":\"Cowgirl+\",\"9\":\"Zeus\",\"10\":\"Inquisitor\",\"11\":\"Whisper\",\"12\":\"Taurus\",\"13\":\"Book+69\",\"14\":\"Scissor\",\"15\":\"Seesaw\",\"16\":\"Sex+Slave\",\"17\":\"Cradle\",\"18\":\"Reverse+Cowgirl\",\"19\":\"Venus\"},\"tribe\":[\"Not+Given\",\"Bear\",\"Clean-Cut\",\"Geek\",\"Twink\",\"Daddy\",\"Jock\",\"BDSM\"],\"islam_cult\":[\"Not+Given\",\"Islam+-+Sunni\",\"Islam+-+Shiite\",\"Islam+-+Sufism\",\"Islam+-+Ahmadiyya\",\"Islam+-+Other\",\"Willing+to+revert\",\"Other\"],\"religious_values\":[\"Not+Given\",\"Very+Religious\",\"Religious\",\"Not+Religious\"],\"eating_habits\":[\"Not+Given\",\"Halal+foods+always\",\"Halal+foods+when+I+can\",\"No+special+restrictions\"],\"hijab_wearing\":[\"Not+Given\",\"Yes\",\"Sometimes\",\"No\"],\"muslim_born\":[\"Not+Given\",\"Born+a+muslim\",\"Reverted+to+Islam\",\"Plan+to+revert+to+Islam\"],\"religious_services\":[\"Not+Given\",\"Daily\",\"Only+on+Jummah+/+Fridays\",\"Sometimes\",\"Only+During+Ramadan\",\"Never\"],\"read_quran\":[\"Not+Given\",\"Daily\",\"Ocassionally\",\"Only+During+Ramadan\",\"Only+on+Jummah+/+Fridays\",\"Read+translated+version\",\"Never+Read\",\"Prefer+not+to+say\"],\"zodiacSign\":[\"Not+Given\",\"Aries\",\"Taurus\",\"Gemini\",\"Cancer\",\"Leo\",\"Virgo\",\"Libra\",\"Scorpio\",\"Sagittarius\",\"Capricorn\",\"Aquarius\",\"Pisces\",\"Rather+not+say\"],\"bloodType\":[\"Not+Given\",\"0\",\"A\",\"B\",\"AB\",\"Rather+not+say\"],\"looking_for\":{\"1\":\"Friendship\",\"2\":\"Email+or+Chat\",\"3\":\"Relationship\",\"4\":\"Fun\",\"5\":\"Other\",\"6\":\"Tell+you+later\"},\"hobby\":{\"1\":\"Watching/playing+Sports\",\"2\":\"Listening+to+music\",\"3\":\"Karaoke+and+Band\",\"4\":\"Cooking/Gourmet\",\"5\":\"Shopping/Fashion\",\"6\":\"Outdoor+activity\",\"7\":\"Car/Bike\",\"8\":\"Language+study\",\"9\":\"Reading+manga/books\",\"10\":\"Watching+TV/films/serials\",\"11\":\"Games\",\"12\":\"Internet\",\"13\":\"Pets\",\"14\":\"Health/Fitness\",\"15\":\"Other\"},\"moneyRole\":[\"Not+Given\",\"Sugarbabby\",\"Sugardaddy\",\"Sugarmommy\"],\"net_worth\":[\"Not+Given\",\"$250,000\",\"$500,000\",\"$1+million\",\"$2+million\",\"$5+million\",\"$10+million\",\"$50+million\",\"$100+million\",\"More+than+$100+million\"],\"income\":{\"0\":\"Not+Given\",\"1\":\"Low\",\"2\":\"Average\",\"3\":\"Well+paid\",\"4\":\"Can+afford+anything\",\"7\":\"Rather+not+say\"},\"professionId\":[\"Not+Given\",\"Other+profession+/+Prefer+not+to+say\",\"Medical+/+Dental+Doctor\",\"Medical+Assistant+/+Technician\",\"Nurse\",\"Scientist+/+Researcher\",\"Army\",\"Navy\",\"Air+Force\",\"Pilot\",\"Air+Crew\",\"Police+/+Sheriff+/+Corrections+Officer\",\"Fire+Fighter\",\"Security+Guards\"],\"availableGenders\":{\"2\":\"female\"}},\"displayPhotoUploadMotivation\":true,\"displaySayhi\":false,\"funnelPayUrl\":null,\"siteLogoBlack\":\"/assets/2427a75c/logoFlirt.png\",\"siteLogoWhite\":\"/assets/2427a75c/logoFlirt.png\",\"siteLogo\":\"/assets/2427a75c/logoFlirt.png\",\"siteName\":\"Flirt\",\"funnelFields\":{\"race\":true,\"gender\":true,\"userGender\":false,\"chatUpLine\":true,\"screenname\":true,\"location\":true,\"iceBreaker\":true,\"birthday\":false,\"password\":false,\"iceBreakerChecked\":true,\"isIcebreakerFunnelCheckBoxEnabled\":true,\"foreignComm\":false},\"profiles\":[],\"options\":null,\"photos\":{\"primary\":{\"avatar\":\"/assets/b0e45e94/image_missing_male.jpg\"}},\"credits\":null,\"iceBreaker\":true,\"statusFieldLength\":140,\"allowedFunnelWithPointingTraffic\":false,\"dateFormat\":[\"m\",\"d\",\"y\"],\"enterAsText\":true,\"csrfToken\":{\"name\":\"CSRF_TOKEN\",\"value\":\""
                + token + "\"}}";
        String body = "data=" + UrlHelper.urlEncoderJson(data) + "&CSRF_TOKEN=" + token;

        Response response = app().rest().request()
                .header("X-Requested-With", "XMLHttpRequest")
                .cookie(getCookie())
                .body(body)
                .when()
                .post("https://www.flirt.com/api/v1/funnel")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public void confirmation() {
        // Make autologin
        app().rest().request()
                .when()
                .get("https://www.flirt.com/site/autologin/key/" + app().userModel().getAutologinKey())
                .then()
                .statusCode(302);
        app().log().info("AutologinKey - " + app().userModel().getAutologinKey());
        // Get csrfToken
        Response response = app().rest()
                .request()
                .header("X-Requested-With", "XMLHttpRequest")
                .when()
                .get("https://www.flirt.com/api/v1/appData")
                .then()
                .statusCode(200)
                .extract()
                .response();

        app().userModel().setCsrfToken(response.jsonPath().get("data.csrfToken.value").toString());
    }


    /**
     * Get location from index page
     *
     * @return String location
     */
    private String getLocationFromIndex() {
        Response response = app().rest().request()
                .cookie(getCookie())
                .when()
                .get("https://www.benaughty.com")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String location = "";
        Elements userForms;

        try {
            Document doc = Jsoup.parse(response.asString());
            doc.outputSettings().charset("UTF-8");
            userForms = doc.getElementsByAttributeValueMatching("name", "location");
        } catch (Exception ex) {
            throw new TestException(this.getClass().getName() + " Unable to get location from index: " + ex);
        }

        for (Element form : userForms) {
            location = form.attr("value");
            if (!Strings.isNullOrEmpty(location)) {
                break;
            }
        }

        if (location.isEmpty()) {
            app().log().error("Index page field location is empty!");
            return "London";
        }
        return location;
    }

    public void disableNotificationSettings() {
        String token = app().userModel().getCsrfToken();
        String data = "NotificationSettingsForm[User like][site]=false&" +
                "NotificationSettingsForm[User match][site]=false&" +
                "NotificationSettingsForm[Notifications from admin][site]=false&" +
                "NotificationSettingsForm[New message][site]=false&" +
                "NotificationSettingsForm[New browse][site]=false&" +
                "NotificationSettingsForm[User alert new photo][site]=false&" +
                "NotificationSettingsForm[User alert new member][site]=false&" +
                "NotificationSettingsForm[Ask for photo][site]=false&" +
                "NotificationSettingsForm[Ask for details][site]=false&" +
                "NotificationSettingsForm[Ask for photoUploaded][site]=false&" +
                "NotificationSettingsForm[Ask for detailsAdded][site]=false&";
        String body = data + "&CSRF_TOKEN=" + token;

        Response response = app().rest().request()
                .header("X-Requested-With", "XMLHttpRequest")
                .cookie(getCookie())
                .body(body)
                .when()
                .post("https://www.flirt.com/api/v1/account/notificationSettings")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public void disableNotificationMessages() {
        String token = app().userModel().getCsrfToken();
        String data = "NotificationMessagesForm[Promo messages][messages]=false&";
        String body = data + "&CSRF_TOKEN=" + token;

        Response response = app().rest().request()
                .header("X-Requested-With", "XMLHttpRequest")
                .cookie(getCookie())
                .body(body)
                .when()
                .post("https://www.flirt.com/api/v1/account/notificationMessages")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public void disableUserSubscription() {
        String token = app().userModel().getCsrfToken();
        String data = "UserSubscriptionForm[eEmail][Matches]=0&" +
                "UserSubscriptionForm[eEmail][On site activity]=0&" +
                "UserSubscriptionForm[eEmail][Site offers]=0&" +
                "UserSubscriptionForm[eEmail][Service alerts]=0&" +
                "UserSubscriptionForm[webPush][Matches]=0&" +
                "UserSubscriptionForm[webPush][On site activity]=0&" +
                "UserSubscriptionForm[webPush][Site offers]=0&" +
                "UserSubscriptionForm[webPush][Service alerts]=0&" +
                "UserSubscriptionForm[pushIos][Matches]=0&" +
                "UserSubscriptionForm[pushIos][On site activity]=0&" +
                "UserSubscriptionForm[pushIos][Site offers]=0&" +
                "UserSubscriptionForm[pushIos][Service alerts]=0&" +
                "UserSubscriptionForm[pushAndroid][Matches]=0&" +
                "UserSubscriptionForm[pushAndroid][On site activity]=0&" +
                "UserSubscriptionForm[pushAndroid][Site offers]=0&" +
                "UserSubscriptionForm[pushAndroid][Service alerts]=0&" +
                "UserSubscriptionForm[sms][Matches]=0&" +
                "UserSubscriptionForm[sms][On site activity]=0&" +
                "UserSubscriptionForm[sms][Site offers]=0&" +
                "UserSubscriptionForm[sms][Service alerts]=0&";
        String body = data + "&CSRF_TOKEN=" + token;

        Response response = app().rest().request()
                .header("X-Requested-With", "XMLHttpRequest")
                .cookie(getCookie())
                .body(body)
                .when()
                .post("https://www.flirt.com/api/v1/userSubscription")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}