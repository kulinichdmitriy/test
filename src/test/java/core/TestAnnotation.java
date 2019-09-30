package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class AnnotTest {
    static final Logger log = LogManager.getRootLogger();
    static final Logger userLog = LogManager.getLogger(AnnotationTest.class);

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
    public void BeforeGroups()
    {
	log.info("@BeforeGroups");
    }

    @BeforeMethod
    public void BeforeMethod()
    {
	log.info("@BeforeMethod");
    }

    @Test
    public void Test()
    {
	log.info("@Test");
    }

    @AfterMethod
    public void AfterMethod()
    {
	log.info("@AfterMethod");
    }


}
