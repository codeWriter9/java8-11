import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


class Main {    


  public static void main(String[] args) {    
    System.out.println("Java 8 Date Time API");
    LocalDate today = LocalDate.now();    
    LocalDateTime startOfToday = today.atStartOfDay();
    LocalDateTime now = LocalDateTime.now();
    System.out.println(" start of today:=" + startOfToday);
    System.out.println(" Current Time  :=" + now);
    long hours = startOfToday.until( now, ChronoUnit.HOURS ) % 24;
    long mins  = startOfToday.until( now, ChronoUnit.MINUTES ) % 60;
    long secs  = startOfToday.until( now, ChronoUnit.SECONDS );
    System.out.println(hours + " : " + mins + " : " + secs);
    ZonedDateTime zonedDateTime = today.atStartOfDay(ZoneId.systemDefault());
  }

}