import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;



public class DateTimeDemo {

      public LocalDateTime currentTimeToday() {
        return LocalDateTime.now();
      }

      public LocalDate today() {
        return LocalDate.now();
      }

      public LocalTime currentTime() {
        return LocalTime.now();
      }

      public Long millisTillNow() {
        return Clock.systemUTC().millis();
      }

      public ZoneId utcZoneId() {
        return ZoneId.of("Z");
      }

      public ZoneOffset utcZoneOffset() {
        return ZoneOffset.UTC;
      }

      public LocalDateTime currentTimeFromMillis() {
        return LocalDateTime.ofInstant(
          Instant.ofEpochMilli(millisTillNow()),
            utcZoneId()
        );
      }
}