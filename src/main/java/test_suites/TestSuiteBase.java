package test_suites;

import core.WebDriverHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class TestSuiteBase extends WebDriverHelper {
    // static final Logger log = LogManager.getRootLogger();
    static final Logger log = LogManager.getLogger(TestSuiteBase.class);

    @BeforeSuite
    public void beforeSuite() {
	log.info("@BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
	log.info("@BeforeTest");
	init();
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
	close();
    }

    @AfterSuite
    public void afterSuite() {
	log.info("@AfterSuite");
    }

}
