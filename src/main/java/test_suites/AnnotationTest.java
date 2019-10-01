package test_suites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class AnnotationTest {
    static final Logger log = LogManager.getRootLogger();
  //  static final Logger userLog = LogManager.getLogger(TestAnnotation.class);

    @BeforeSuite
    public void BeforeSuite() {
	log.info("@BeforeSuite");

    }   @AfterMethod
    public void AfterMethod() {
	log.info("@AfterMethod");
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




}
