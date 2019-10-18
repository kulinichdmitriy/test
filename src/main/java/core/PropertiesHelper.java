package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    FileInputStream fis;
    Properties property = new Properties();
    String prop;

    public String getProperties(String properties) {

	try {
	    fis = new FileInputStream("src/main/resources/project.properties");
	    property.load(fis);
	    prop = property.getProperty(properties);

	    System.out.println(prop);

	} catch (IOException e) {
	    System.err.println("ОШИБКА: Файл свойств отсуствует!");
	}
	return prop;
    }
}
