package test_suites;

import core.PropertiesHelper;
import org.testng.annotations.Test;

public class Test1 extends TestSuiteBase {

    @Test
    public void method1() {
	log.info("Class Test1 method1");

	getMyProperties("phoenix.password");
	getMyProperties("phoenix.login");

	wd().openUrl("http://m.flirt.com");
    }

  /*  @Test
    public void method2() {
	log.info("Class Test1 method2");
    }

    @Test
    public void method3() {
	log.info("Class Test1 method3");
    }*/
}
