package test_suites;

import org.testng.annotations.Test;

public class Test1 extends TestSuiteBase {

    @Test
    public void method1() {
	log.info("Class Test1 method1");
	openUrl("http://www.google.com");
    }

    @Test
    public void method2() {
	log.info("Class Test1 method2");
    }

    @Test
    public void method3() {
	log.info("Class Test1 method3");
    }
}
