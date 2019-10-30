package test_suites;

import org.testng.annotations.Test;

import static core.ApplicationManager.app;

public class Test1 extends TestSuiteBase {

    @Test
    public void method1() {
	app().wd().openUrl("http://m.flirt.com");
	app().property().getProperty("phoenix.password");
	app().log().info("---------- TEST INFO----------");
	app().log().warning("--------- TEST WARNING---------");
	app().log().error("------------ TEST ERROR -----------");
	app().property().getProperty("");
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
