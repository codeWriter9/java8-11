import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

  public static void threadCalls() {
    // Thread call 
    // call 1
    new RunnableDemo().oldWay().start();    
    // call 2
    new RunnableDemo().newWay().start();
    // call 3
    new Thread(new RunnableDemo().newWay2()).start();
    
  }    

  public static void streamCalls() {
    // Stream 
    StreamDemo streamDemo = new StreamDemo();
    // Lambda consume a Stream
    streamDemo.fixedStream().forEach(streamDemo.lambdaConsume());
    System.out.println();
    // Consume a Stream using Method Expression
    streamDemo.fixedStream().forEach(streamDemo.methodRefConsume());  
    System.out.println();
    // Lambda consume a random Double Stream
    streamDemo.randomStream().limit(5).forEach(streamDemo.lambdaConsumeDouble());
    System.out.println();
    // Consume a random Double Stream using Method Expression
    streamDemo.randomStream().limit(5).forEach(streamDemo.methodRefConsumeDouble());  
    System.out.println();

    // Lambda consume a random Double Stream
    streamDemo.randomStream().limit(5).map(x -> x * 100)
    .mapToInt(x -> x.intValue()).boxed().forEach(streamDemo.lambdaConsume());
    System.out.println();
    // Consume a random Double Stream using Method Expression
    streamDemo.randomStream().limit(5).map(x -> x * 100)
    .mapToInt(x -> x.intValue()).boxed().forEach(streamDemo.methodRefConsume());  
    System.out.println();
  }

  public static void streamCalls2() {
    // Stream 
    StreamDemo streamDemo = new StreamDemo();

    streamDemo.mcu().stream().sorted(Comparator.naturalOrder())
    .collect(Collectors.toList()).forEach
    (streamDemo.lambdaConsumeStr());
    System.out.println();

    streamDemo.mcu().stream().sorted(Comparator.naturalOrder())
    .collect(Collectors.toList()).forEach
    (streamDemo.methodRefConsumeStr());
    System.out.println();

  }

  public static void streamCalls3() {
    // Stream 
    StreamDemo streamDemo = new StreamDemo();

    streamDemo.mcu().stream().sorted(Comparator.reverseOrder())
    .collect(Collectors.toList()).forEach
    (streamDemo.lambdaConsumeStr());
    System.out.println();

    streamDemo.mcu().stream().sorted(Comparator.reverseOrder())
    .collect(Collectors.toList()).forEach
    (streamDemo.methodRefConsumeStr());
    System.out.println();

  }

  public static void streamCalls4() {
    // Stream 
    StreamDemo streamDemo = new StreamDemo();

    streamDemo.mcu().stream().sorted(Comparator.comparing(String::toLowerCase))
    .collect(Collectors.toList()).forEach
    (streamDemo.lambdaConsumeStr());
    System.out.println();

    streamDemo.mcu().stream().sorted(Comparator.comparing(String::toLowerCase))
    .collect(Collectors.toList()).forEach
    (streamDemo.methodRefConsumeStr());
    System.out.println();

  }

  public static void streamCalls5() {
    // Stream 
    StreamDemo streamDemo = new StreamDemo();

    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList()).forEach
    (streamDemo.lambdaConsumeStr());
    System.out.println();

    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList()).forEach
    (streamDemo.methodRefConsumeStr());
    System.out.println();

  }

  public static void streamCalls6() {
    // Stream 
    StreamDemo streamDemo = new StreamDemo();

    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length)
    .thenComparing(Comparator.reverseOrder()))
    .collect(Collectors.toList()).forEach
    (streamDemo.lambdaConsumeStr());
    System.out.println();

    streamDemo.mcu().stream().sorted(Comparator.comparing(String::length)
    .thenComparing(Comparator.reverseOrder()))
    .collect(Collectors.toList()).forEach
    (streamDemo.methodRefConsumeStr());
    System.out.println();

  }

  public static void main(String[] args) {    
    //threadCalls();
    //streamCalls();    
    //streamCalls2();
    //streamCalls3();
    //streamCalls4();
    //streamCalls5();
    streamCalls6();
  }
}