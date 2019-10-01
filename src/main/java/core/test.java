package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test_suites.AnnotationTest;

public class test {

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger userLogger = LogManager.getLogger(test.class);

    public static void main(String[] args) {

	AnnotationTest at = new AnnotationTest(); }
}

