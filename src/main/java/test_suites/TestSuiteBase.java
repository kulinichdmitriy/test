package test_suites;

import core.ApplicationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class TestSuiteBase extends ApplicationManager {
    // static final Logger log = LogManager.getRootLogger();
    static final Logger log = LogManager.getLogger(TestSuiteBase.class);

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
	wd().close();
    }

    @AfterSuite
    public void afterSuite() {
	log.info("@AfterSuite");
    }

}