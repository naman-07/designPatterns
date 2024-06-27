package datetimeapis;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeJava8 {
    public static void main(String[] args) {
        // Creating an Instant
        Instant instant = Instant.now();
        // Getting epoch seconds and nanoseconds
        long epochSeconds = instant.getEpochSecond();
        int nanoOfSecond = instant.getNano();
        System.out.println("Epoch Seconds: " + epochSeconds);
        System.out.println("Nanoseconds: " + nanoOfSecond);
        // Manipulating Instant
        Instant futureInstant = instant.plusSeconds(10);
        Instant pastInstant = instant.minusSeconds(5);
        System.out.println("Future Instant: " + futureInstant);
        System.out.println("Past Instant: " + pastInstant);
        // Converting Instant to LocalDateTime in the system default time zone
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("LocalDateTime: " + localDateTime);
        // Converting Instant to ZonedDateTime in UTC
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        System.out.println("ZonedDateTime (UTC): " + zonedDateTime);
        // Formatting Instant (by first converting to LocalDateTime)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedInstant = formatter.format(zonedDateTime);
        System.out.println("Formatted Instant: " + formattedInstant);
    }
    /**
     * The issue arises because Instant does not directly support formatting
     * using DateTimeFormatter as it lacks the concept of a calendar system,
     * including fields like YearOfEra. You need to convert the Instant to a
     * ZonedDateTime or LocalDateTime before formatting it.
     */
    
    /**
     * YearOfEra is a temporal field in Java's date-time API (java.time) that
     * represents the year within an era. The concept of an era is used in
     * calendars to represent significant periods of time, such as the BCE
     * (Before Common Era) and CE (Common Era) in the Gregorian calendar. In the
     * ISO-8601 calendar system, which is used by default in Java's java.time
     * API, the eras are BCE (represented as 0) and CE (represented as 1).
     */
    /**
     * example-> Example: In the Gregorian calendar: CE (Common Era): Year 2023
     * CE -> Era: CE, YearOfEra: 2023 BCE (Before Common Era): Year 500 BCE ->
     * Era: BCE, YearOfEra: 500
     */
}
