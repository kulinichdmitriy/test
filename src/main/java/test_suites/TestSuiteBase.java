package test_suites;

import org.testng.annotations.*;

import static core.ApplicationManager.app;

public class TestSuiteBase {

    @BeforeSuite
    public void beforeSuite() {
	app().log.info("@BeforeSuite");
	app().wd().openUrl("");
    }

    @BeforeTest
    public void beforeTest() {
	app().log.info("@BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
	app().log.info("@BeforeClass");
    }

    @BeforeGroups
    public void beforeGroups() {
	app().log.info("@BeforeGroups");
    }

    @BeforeMethod
    public void beforeMethod() {
	app().log.info("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
	app().log.info("@AfterMethod");
    }

    @AfterGroups
    public void afterGroups() {
	app().log.info("@AfterGroups");
    }

    @AfterClass
    public void afterClass() {
	app().log.info("@AfterClass");
    }

    @AfterTest
    public void afterTest() {
	app().log.info("@AfterTest");
	app().wd().quit();
    }

    @AfterSuite
    public void afterSuite() {
	app().log.info("@AfterSuite");
    }

}
