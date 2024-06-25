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
        // Manipulating Instant
        Instant futureInstant = instant.plusSeconds(10);
        Instant pastInstant = instant.minusSeconds(5);
        // Converting Instant to LocalDateTime in the system default time zone
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        // Converting Instant to ZonedDateTime in UTC
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        // Formatting Instant
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedInstant = formatter.format(instant);
        // Output
        System.out.println("Current Instant: " + instant);
        System.out.println("Epoch Seconds: " + epochSeconds);
        System.out.println("Nano of Second: " + nanoOfSecond);
        System.out.println("Future Instant: " + futureInstant);
        System.out.println("Past Instant: " + pastInstant);
        System.out.println("Local DateTime: " + localDateTime);
        System.out.println("Zoned DateTime (UTC): " + zonedDateTime);
        System.out.println("Formatted Instant: " + formattedInstant);
    }
}
