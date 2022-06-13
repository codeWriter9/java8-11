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

  private static DateTimeDemo dateTimeDemo;

  public static DateTimeDemo getInstance() {
    if(dateTimeDemo == null) {
      dateTimeDemo = new DateTimeDemo();
    }
    return dateTimeDemo;
  }

      public void timeDemoCalls() {
    ConsumersFactory.lambdaConsumeStr().accept("Time Today: " + this.currentTimeToday()
    );
    ConsumersFactory.methodRefConsumeStr().accept("Time Today[Zone]: " + this.currentTimeToday().toInstant(ZoneOffset.UTC));   
    
    ConsumersFactory.methodRefConsumeStr().accept("Today: " + this.today()
    );
    ConsumersFactory.lambdaConsumeStr().accept("Time Now: " + this.currentTime()
    );

    ConsumersFactory.newLine();

    ConsumersFactory.lambdaConsumeStr().accept("Millis: " + this.currentTimeToday().toInstant(ZoneOffset.UTC).toEpochMilli());

    ConsumersFactory.methodRefConsumeStr().accept("Millis Seconds Now: " + this.millisTillNow());

    ConsumersFactory.lambdaConsumeStr().accept("Legacy Date with Millis: " + new Date(this.millisTillNow()));

    ConsumersFactory.methodRefConsumeStr().accept("Current Time: " + this.currentTimeFromMillis()); 

    ConsumersFactory.lambdaConsumeStr().accept("Current Time[From Date]: " + this.currentTimeFromMillis(new Date()));       

    ConsumersFactory.lambdaConsumeStr().accept("Current Time[IST]: " + this.currentTimeFromMillis(new Date(), this.istZoneId()));    

    ConsumersFactory.newLine();
  }

  public  void timeDemoCalls2() {
    ConsumersFactory.lambdaConsumeStr().accept("Days Since 1970: " + this.daysSince1970());
    ConsumersFactory.lambdaConsumeStr().accept("Yesterday: " + this.yesterday());    
    ConsumersFactory.lambdaConsumeStr().accept("Today: " + this.today());    
    ConsumersFactory.lambdaConsumeStr().accept("Tomorrow: " + this.tomorrow());    
    ConsumersFactory.newLine();
    ConsumersFactory.lambdaConsumeStr().accept("Noon: " + this.noon());    
    ConsumersFactory.lambdaConsumeStr().accept("Midnight: " + this.midNight());    
    ConsumersFactory.newLine();

  }

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