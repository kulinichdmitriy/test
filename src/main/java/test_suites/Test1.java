package test_suites;

import core.LoggerHelper;
import org.testng.annotations.Test;

import static core.ApplicationManager.app;

public class Test1 extends TestSuiteBase {
LoggerHelper log = new LoggerHelper();
    @Test
    public void method1() {
	app().log.info("Class Test1 method1");
	app().wd().openUrl("http://m.flirt.com");
	app().property().get("phoenix.password");
	log.info();
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
