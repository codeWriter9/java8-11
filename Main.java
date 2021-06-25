import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;
import java.time.ZoneOffset;

public class Main {

  private static RunnableDemo runnableDemo = new RunnableDemo();
  private static StreamDemo streamDemo = new StreamDemo();
  private static ConsumersFactory consumer = new ConsumersFactory();
  private static PredicateDemo predicateDemo = new PredicateDemo();
  private static OptionalDemo optionalDemo = new OptionalDemo();
  private static StringDemo stringDemo = new StringDemo();
  private static DateTimeDemo dateTimeDemo = new DateTimeDemo();

  public static void threadCalls() {
    // Thread call 
    // call 1
    runnableDemo.oldWay().start();    
    // call 2
    runnableDemo.newWay().start();
    // call 3
    new Thread(runnableDemo.newWay2()).start();
    
  }    

  public static void streamCalls() {    
    // Lambda consume a Stream
    streamDemo.fixedStream().forEach(consumer.lambdaConsume());
    System.out.println();
    // Consume a Stream using Method Expression
    streamDemo.fixedStream().forEach(consumer.methodRefConsume());  
    System.out.println();
    // Lambda consume a random Double Stream
    streamDemo.randomStream().limit(5).forEach(consumer.lambdaConsumeDouble());
    System.out.println();
    // Consume a random Double Stream using Method Expression
    streamDemo.randomStream().limit(5).forEach(consumer.methodRefConsumeDouble());  
    System.out.println();

    // Lambda consume a random Double Stream
    streamDemo.randomStream().limit(5).map(x -> x * 100)
    .mapToInt(x -> x.intValue()).boxed().forEach(consumer.lambdaConsume());
    System.out.println();
    // Consume a random Double Stream using Method Expression
    streamDemo.randomStream().limit(5).map(x -> x * 100)
    .mapToInt(x -> x.intValue()).boxed().forEach(consumer.methodRefConsume());  
    System.out.println();
  }

  public static void streamCalls2() {    
    // Lambda consume a fixed String Stream
    // Sorted in natural order
    streamDemo.mcu().stream().sorted(Comparator.naturalOrder())
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    System.out.println();
    // Consume a fixed String Stream using Method Expression
    // Sorted in natural order
    streamDemo.mcu().stream().sorted(Comparator.naturalOrder())
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    System.out.println();

  }

  public static void streamCalls3() {    
    // Lambda consume a fixed String Stream
    // Sorted in reverse order
    streamDemo.mcu().stream().sorted(Comparator.reverseOrder())
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    System.out.println();
    // Consume a fixed String Stream using Method Expression
    // Sorted in reverse order
    streamDemo.mcu().stream().sorted(Comparator.reverseOrder())
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    System.out.println();

  }

  public static void streamCalls4() {    
    // Lambda consume a fixed String Stream
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::toLowerCase))
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    System.out.println();
    // Consume a fixed String Stream using Method Expression
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::toLowerCase))
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    System.out.println();

  }

  public static void streamCalls5() {    
    // Lambda consume a fixed String Stream
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    System.out.println();
    // Consume a fixed String Stream using Method Expression
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    System.out.println();

  }

  public static void streamCalls6() {    
    // Lambda consume a fixed String Stream
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length)
    .thenComparing(Comparator.reverseOrder()))
    .collect(Collectors.toList()).forEach
    (consumer.lambdaConsumeStr());
    System.out.println();
    // Consume a fixed String Stream using Method Expression
    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length)
    .thenComparing(Comparator.reverseOrder()))
    .collect(Collectors.toList()).forEach
    (consumer.methodRefConsumeStr());
    System.out.println();
  }

  public static void optionalCalls() {    
    // Consume only if present or show that value is not there
    consumer.lambdaConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).orElse("Value Not Present"));
    consumer.lambdaConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).orElse("Value Not Present"));

    consumer.methodRefConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).orElse("Value Not Present"));
    consumer.methodRefConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).orElse("Value Not Present"));
  }

  public static void optionalCalls2() {    
    // Consume only if present 
    optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).ifPresent(consumer.lambdaConsumeStr());
    optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).ifPresent(consumer.lambdaConsumeStr());
    optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).ifPresent(consumer.methodRefConsumeStr());
    optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).ifPresent(consumer.methodRefConsumeStr());
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
    
    consumer.lambdaConsumeStr().accept("Millis: " + dateTimeDemo.currentTimeToday().toInstant(ZoneOffset.UTC).toEpochMilli());
    
    consumer.methodRefConsumeStr().accept("Today: " + dateTimeDemo.today()
    );
    consumer.lambdaConsumeStr().accept("Time Now: " + dateTimeDemo.currentTime()
    );

    consumer.methodRefConsumeStr().accept("Millis Seconds Now: " + dateTimeDemo.millisTillNow());

    consumer.lambdaConsumeStr().accept("Legacy Date with Millis: " + new Date(dateTimeDemo.millisTillNow()));

    consumer.methodRefConsumeStr().accept("Current Time: " + dateTimeDemo.currentTimeFromMillis()); 

    consumer.lambdaConsumeStr().accept("Current Time[From Date]: " + dateTimeDemo.currentTimeFromMillis(new Date()));    

    System.out.println();
  }

  public static void timeDemoCalls2() {
    consumer.lambdaConsumeStr().accept("Yesterday: " + dateTimeDemo.yesterday());    
    consumer.lambdaConsumeStr().accept("Today: " + dateTimeDemo.today());    
    consumer.lambdaConsumeStr().accept("Tomorrow: " + dateTimeDemo.tomorrow());    
  }

  public static void main(String[] args) {    
    //threadCalls();
    //streamCalls();    
    //streamCalls2();
    //streamCalls3();
    //streamCalls4();
    //streamCalls5();
    //streamCalls6();
    //optionalCalls();
    //optionalCalls2();
    //stringCalls();
    timeDemoCalls();
    timeDemoCalls2();
  }
}