package core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeHelper {

    public String getCurrentTime(String format, String zone) {
	Date date = new Date();
	DateFormat time = new SimpleDateFormat(format);
	time.setTimeZone(TimeZone.getTimeZone(zone));
	String currentTime = time.format(date);
	return currentTime;
    }
    public String getCurrentTime(String format) {
	Date date = new Date();
	DateFormat df = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
	DateFormat time = new SimpleDateFormat(format);
	df.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
	String currentTime = time.format(date);
	return currentTime;
    }
}
