import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;
import java.time.ZoneOffset;




public class Main {


  private static StreamDemo streamDemo = new StreamDemo();
  private static ConsumersFactory consumer = new ConsumersFactory();  
  
  private static StringDemo stringDemo = new StringDemo();
  private static DateTimeDemo dateTimeDemo = new DateTimeDemo();


  public static void streamCalls() {    
    // Lambda consume a Stream
    streamDemo.fixedStream().forEach(consumer.lambdaConsume());
    ConsumersFactory.newLine();
    // Consume a Stream using Method Expression
    streamDemo.fixedStream().forEach(consumer.methodRefConsume());  
    ConsumersFactory.newLine();


    // Lambda consume a Stream
    streamDemo.addBy(x -> x + 1).limit(5)
      .forEach(consumer.lambdaConsume());
    ConsumersFactory.newLine();
    // Consume a Stream using Method Expression
    streamDemo.addBy(x -> x + 1).limit(5)
      .forEach(consumer.methodRefConsume());  
    ConsumersFactory.newLine();

    
    // Lambda consume a random Double Stream
    streamDemo.randomStream().limit(5).forEach(consumer.lambdaConsumeDouble());
    ConsumersFactory.newLine();
    // Consume a random Double Stream using Method Expression
    streamDemo.randomStream().limit(5).forEach(consumer.methodRefConsumeDouble());  
    ConsumersFactory.newLine();

    // Lambda consume a random Double Stream
    streamDemo.randomStream().limit(5).map(x -> x * 100)
    .mapToInt(x -> x.intValue()).boxed().forEach(consumer.lambdaConsume());
    ConsumersFactory.newLine();
    // Consume a random Double Stream using Method Expression
    streamDemo.randomStream().limit(5).map(x -> x * 100)
    .mapToInt(x -> x.intValue()).boxed().forEach(consumer.methodRefConsume());  
    ConsumersFactory.newLine();
  }

  public static void streamCalls2() {    
    // Lambda consume a fixed String Stream
    // Sorted in natural order
    streamDemo.mcu().stream().sorted(Comparator.naturalOrder())
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    // Sorted in natural order
    streamDemo.mcu().stream().sorted(Comparator.naturalOrder())
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    ConsumersFactory.newLine();

  }

  public static void streamCalls3() {    
    // Lambda consume a fixed String Stream
    // Sorted in reverse order
    streamDemo.mcu().stream().sorted(Comparator.reverseOrder())
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    // Sorted in reverse order
    streamDemo.mcu().stream().sorted(Comparator.reverseOrder())
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    ConsumersFactory.newLine();

  }

  public static void streamCalls4() {    
    // Lambda consume a fixed String Stream
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::toLowerCase))
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::toLowerCase))
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    ConsumersFactory.newLine();

  }

  public static void streamCalls5() {    
    // Lambda consume a fixed String Stream
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    ConsumersFactory.newLine();

  }

  public static void streamCalls6() {    
    // Lambda consume a fixed String Stream
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length)
    .thenComparing(Comparator.reverseOrder()))
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length)
    .thenComparing(Comparator.reverseOrder()))
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    ConsumersFactory.newLine();
  }

  

  public static void stringCalls() {    
    consumer.lambdaConsumeStr().accept(stringDemo.repeatCaller("La ", 2, "Land"));
    consumer.lambdaConsumeStr().accept(stringDemo.repeatCaller("No Man's", "Land"));
    consumer.lambdaConsumeStr().accept(">>" + stringDemo.stripCaller("     without Blanks   ") + "<<");
    consumer.methodRefConsumeLong().accept(stringDemo.countLines("This is\nA Multi Line Comment\n."));
  }

  public static void timeDemoCalls() {
    consumer.lambdaConsumeStr().accept("Time Today: " + dateTimeDemo.currentTimeToday()
    );
    consumer.methodRefConsumeStr().accept("Time Today[Zone]: " + dateTimeDemo.currentTimeToday().toInstant(ZoneOffset.UTC));   
    
    consumer.methodRefConsumeStr().accept("Today: " + dateTimeDemo.today()
    );
    consumer.lambdaConsumeStr().accept("Time Now: " + dateTimeDemo.currentTime()
    );

    ConsumersFactory.newLine();

    consumer.lambdaConsumeStr().accept("Millis: " + dateTimeDemo.currentTimeToday().toInstant(ZoneOffset.UTC).toEpochMilli());

    consumer.methodRefConsumeStr().accept("Millis Seconds Now: " + dateTimeDemo.millisTillNow());

    consumer.lambdaConsumeStr().accept("Legacy Date with Millis: " + new Date(dateTimeDemo.millisTillNow()));

    consumer.methodRefConsumeStr().accept("Current Time: " + dateTimeDemo.currentTimeFromMillis()); 

    consumer.lambdaConsumeStr().accept("Current Time[From Date]: " + dateTimeDemo.currentTimeFromMillis(new Date()));       

    consumer.lambdaConsumeStr().accept("Current Time[IST]: " + dateTimeDemo.currentTimeFromMillis(new Date(), dateTimeDemo.istZoneId()));    

    ConsumersFactory.newLine();
  }

  public static void timeDemoCalls2() {
    consumer.lambdaConsumeStr().accept("Days Since 1970: " + dateTimeDemo.daysSince1970());
    consumer.lambdaConsumeStr().accept("Yesterday: " + dateTimeDemo.yesterday());    
    consumer.lambdaConsumeStr().accept("Today: " + dateTimeDemo.today());    
    consumer.lambdaConsumeStr().accept("Tomorrow: " + dateTimeDemo.tomorrow());    
    ConsumersFactory.newLine();
    consumer.lambdaConsumeStr().accept("Noon: " + dateTimeDemo.noon());    
    consumer.lambdaConsumeStr().accept("Midnight: " + dateTimeDemo.midNight());    
    ConsumersFactory.newLine();

  }

  public static void main(String[] args) {    
    //RunnableDemo.getInstance().threadCalls();
    // streamCalls();    
    // streamCalls2();
    // streamCalls3();
    // streamCalls4();
    // streamCalls5();
    // streamCalls6();
    OptionalDemo.getInstance().optionalCalls(new ConsumersFactory());
    OptionalDemo.getInstance().optionalCalls2(new ConsumersFactory());
    // stringCalls();
    // timeDemoCalls();
    // timeDemoCalls2();
  }
}