package test_suites;

import core.DateTimeHelper;
import org.testng.annotations.*;

import static core.ApplicationManager.app;

public class TestSuiteBase {

    @BeforeSuite
    public void beforeSuite() {
	this.setProperties();
	app().log().info("@BeforeSuite");
	app().wd().openUrl("https://www.google.com");
    }

    @BeforeTest
    public void beforeTest() {
	app().log().info("@BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
	app().log().info("@BeforeClass");
    }

    @BeforeGroups
    public void beforeGroups() {
	app().log().info("@BeforeGroups");
    }

    @BeforeMethod
    public void beforeMethod() {
	app().log().info("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
	app().log().info("@AfterMethod");
    }

    @AfterGroups
    public void afterGroups() {
	app().log().info("@AfterGroups");
    }

    @AfterClass
    public void afterClass() {
	app().log().info("@AfterClass");
    }

    @AfterTest
    public void afterTest() {
	app().log().info("@AfterTest");
	app().wd().quit();
    }

    @AfterSuite
    public void afterSuite() {
	app().log().info("@AfterSuite");
    }

    private void setProperties() {
	String suiteDate = app().dateTime().getCurrentDateTime(DateTimeHelper.EUROPE_KIEV, DateTimeHelper.DATE_FORMAT);
	String suiteTime = app().dateTime().getCurrentDateTime(DateTimeHelper.EUROPE_KIEV, DateTimeHelper.TIME_FORMAT);
	String reportPath = "reports/"
			+ suiteDate + "/"
			+ suiteTime + "/";
	System.setProperty("suiteDate", suiteDate);
	System.setProperty("suiteTime", suiteTime);
	System.setProperty("reportPath", reportPath);
    }
}
