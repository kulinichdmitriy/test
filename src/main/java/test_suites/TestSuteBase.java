package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class TestSuteBase {
    static final Logger log = LogManager.getRootLogger();

    @BeforeSuite
    public void BeforeSuite() {
	log.info("@BeforeSuite");

    }

    @BeforeTest
    public void BeforeTest() {
	log.info("@BeforeTest");
    }

    @BeforeClass
    public void BeforeClass() {
	log.info("@BeforeClass");
    }

    @BeforeGroups
    public void BeforeGroups() {
	log.info("@BeforeGroups");
    }

    @BeforeMethod
    public void BeforeMethod() {
	log.info("@BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod() {
	log.info("@AfterMethod");
    }

    @AfterGroups
    public void AfterGroups() {
	log.info("@AfterGroups");
    }

    @AfterClass
    public void AfterClass() {
	log.info("@AfterClass");
    }
    @AfterTest
    public void	AfterTest()
    {
	log.info("@AfterTest");
    }
    @AfterSuite
    public void	AfterSuite()
    {
        log.info("@AfterSuite");
    }

}
