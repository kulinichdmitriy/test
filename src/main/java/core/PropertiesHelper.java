package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private PropertiesHelper proper;

    FileInputStream fis;

    PropertiesHelper() {
	try {
	    fis = new FileInputStream("src/main/resources/project.properties");
	} catch (IOException e) {
	    System.err.println("ОШИБКА: Файл свойств отсуствует!");
	}
    }

    public String get(String prop) throws IOException {
	Properties property = new Properties();
	String pr;
	property.getProperty(prop);
	property.load(fis);
	pr = property.getProperty(prop);
	return pr;
    }
}
