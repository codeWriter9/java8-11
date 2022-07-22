import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

enum WeekDay {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;

  public WeekDay next() {
    switch(this) {
      case MONDAY: return TUESDAY;
      case TUESDAY: return WEDNESDAY;
      case WEDNESDAY: return THURSDAY;
      case THURSDAY: return FRIDAY;
      default: return MONDAY;
    }
  } 
}

class Day {
   WeekDay weekDay;
   Day(WeekDay weekDay) {
     this.weekDay = weekDay;
   }

   WeekDay day()  { return weekDay;}
   WeekDay next() { return this.weekDay = weekDay.next(); }
}


class DayRunner implements Runnable {
  WeekDay weekDay;
  Day day;
  CountDownLatch countDownLatch;

  DayRunner(WeekDay weekDay, Day day, 
            CountDownLatch countDownLatch) {
    this.weekDay = weekDay;
    this.day = day;
    this.countDownLatch = countDownLatch;
  }

  public void run() {
    synchronized(day) {
      try {
        while(!day.day().equals(weekDay)) day.wait(10);
        System.out.println(day.day());
        day.next();
        countDownLatch.countDown();
      }
      catch(Exception e) {
        e.printStackTrace();
      }
    }
  }
}


public class MultiThreadingMain {        
  
  public static void main(String[] args) 
  throws InterruptedException {                  
     long start = System.currentTimeMillis();    
     Day day = new Day(WeekDay.MONDAY);
     CountDownLatch latch = new CountDownLatch(10);
     new Thread(new DayRunner(WeekDay.FRIDAY, day, latch)).start();
     new Thread(new DayRunner(WeekDay.MONDAY, day, latch)).start();
     new Thread(new DayRunner(WeekDay.TUESDAY, day, latch)).start();
     new Thread(new DayRunner(WeekDay.THURSDAY, day, latch)).start();
     new Thread(new DayRunner(WeekDay.WEDNESDAY, day, latch)).start();     
     new Thread(new DayRunner(WeekDay.THURSDAY, day, latch)).start();
     new Thread(new DayRunner(WeekDay.WEDNESDAY, day, latch)).start();
     new Thread(new DayRunner(WeekDay.MONDAY, day, latch)).start();
     new Thread(new DayRunner(WeekDay.TUESDAY, day, latch)).start();
     new Thread(new DayRunner(WeekDay.FRIDAY, day, latch)).start();
     latch.await();
     long end = System.currentTimeMillis();
     StringBuilder builder = new StringBuilder("Time Taken = ");
     builder.append((end - start));
     builder.append(" ms");
     System.out.println(builder.toString());
  }
}
