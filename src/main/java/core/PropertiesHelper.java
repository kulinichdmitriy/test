package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private Logger log = LogManager.getLogger(PropertiesHelper.class);
    private FileInputStream fis;
    private Properties property;

    PropertiesHelper() {
	property = new Properties();
	try {
	    fis = new FileInputStream("src/main/resources/project.properties");
	} catch (IOException e) {
	    log.info("ОШИБКА: Файл свойств отсуствует!");
	}
    }

    public String get(String prop) {
	try {
	    property.getProperty(prop);
	    property.load(fis);
	} catch (IOException e) {
	    log.info("ОШИБКА: Файл свойств отсуствует!");
	}
	String pr = property.getProperty(prop);
	System.out.println(pr);
	return pr;
    }
}
