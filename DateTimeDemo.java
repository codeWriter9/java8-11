import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;



public class DateTimeDemo {

      public LocalDateTime currentTimeToday() {
        return LocalDateTime.now();
      }

      public LocalDate today() {
        return LocalDate.now();
      }

      public LocalDate tomorrow() {
        return today().plusDays(1);
      }

      public LocalDate yesterday() {
        return today().minusDays(1);
      }

      public Long daysSince1970() {
        return today().toEpochDay();
      }

      public LocalTime noon() {
        return LocalTime.of(12, 0, 0);
      }

      public LocalTime midNight() {
        return LocalTime.of(23, 59, 59);
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

      public ZoneId istZoneId() {        
        return ZoneId.of("IST", ZoneId.SHORT_IDS);
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


     public LocalDateTime currentTimeFromMillis(Date date) {
        return LocalDateTime.ofInstant(
          Instant.ofEpochMilli(date.getTime()),
            utcZoneId()
        );
      }


    public LocalDateTime currentTimeFromMillis(Date date, ZoneId zoneId) {
        return LocalDateTime.ofInstant(
          Instant.ofEpochMilli(date.getTime()),
            zoneId
        );
      }
}