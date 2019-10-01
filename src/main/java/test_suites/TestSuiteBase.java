package test_suites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class TestSuiteBase {
    static final Logger log = LogManager.getRootLogger();

    @BeforeSuite
    public void beforeSuite() {
	log.info("@BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
	log.info("@BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
	log.info("@BeforeClass");
    }

    @BeforeGroups
    public void beforeGroups() {
	log.info("@BeforeGroups");
    }

    @BeforeMethod
    public void beforeMethod() {
	log.info("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
	log.info("@AfterMethod");
    }

    @AfterGroups
    public void afterGroups() {
	log.info("@AfterGroups");
    }

    @AfterClass
    public void afterClass() {
	log.info("@AfterClass");
    }

    @AfterTest
    public void afterTest() {
	log.info("@AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
	log.info("@AfterSuite");
    }

}
