package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.internal.annotations.TestAnnotation;
import test_suites.AnnotationTest;

public class test {

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger userLogger = LogManager.getLogger(test.class);

    public static void main(String[] args) {

        AnnotationTest ta = new AnnotationTest();


    }
}
