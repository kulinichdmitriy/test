package core.helpers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH-mm-ss";
    public static final String EUROPE_KIEV = "Europe/Kiev";

    /**
     * Get current DateTime by zoneId and format
     *
     * @param zoneId
     * @param format
     * @return String DateTime
     */
    public String getCurrentDateTime(String zoneId, String format) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(zoneId));
	return localDateTime.format(formatter);
    }
}
