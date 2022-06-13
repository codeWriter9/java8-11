import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;



public class StreamDemo {

  private static StreamDemo streamDemo;

  public static StreamDemo getInstance() {
    if(streamDemo == null) {
       streamDemo = new StreamDemo();
    }
    return streamDemo;
  }

  public void streamCalls() {    
    // Lambda consume a Stream
    this.fixedStream().forEach(ConsumersFactory.lambdaConsume());
    ConsumersFactory.newLine();
    // Consume a Stream using Method Expression
    this.fixedStream().forEach(ConsumersFactory.methodRefConsume());  
    ConsumersFactory.newLine();


    // Lambda consume a Stream
    this.addBy(x -> x + 1).limit(5)
      .forEach(ConsumersFactory.lambdaConsume());
    ConsumersFactory.newLine();
    // Consume a Stream using Method Expression
    this.addBy(x -> x + 1).limit(5)
      .forEach(ConsumersFactory.methodRefConsume());  
    ConsumersFactory.newLine();

    
    // Lambda consume a random Double Stream
    this.randomStream().limit(5).forEach(ConsumersFactory.lambdaConsumeDouble());
    ConsumersFactory.newLine();
    // Consume a random Double Stream using Method Expression
    this.randomStream().limit(5).forEach(ConsumersFactory.methodRefConsumeDouble());  
    ConsumersFactory.newLine();

    // Lambda consume a random Double Stream
    this.randomStream().limit(5).map(x -> x * 100)
    .mapToInt(x -> x.intValue()).boxed().forEach(ConsumersFactory.lambdaConsume());
    ConsumersFactory.newLine();
    // Consume a random Double Stream using Method Expression
    this.randomStream().limit(5).map(x -> x * 100)
    .mapToInt(x -> x.intValue()).boxed().forEach(ConsumersFactory.methodRefConsume());  
    ConsumersFactory.newLine();
  }

  public void streamCalls2() {    
    // Lambda consume a fixed String Stream
    // Sorted in natural order
    this.mcu().stream().sorted(Comparator.naturalOrder())
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    // Sorted in natural order
    this.mcu().stream().sorted(Comparator.naturalOrder())
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.methodRefConsumeStr());
    ConsumersFactory.newLine();

  }

  public void streamCalls3() {    
    // Lambda consume a fixed String Stream
    // Sorted in reverse order
    this.mcu().stream().sorted(Comparator.reverseOrder())
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    // Sorted in reverse order
    this.mcu().stream().sorted(Comparator.reverseOrder())
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.methodRefConsumeStr());
    ConsumersFactory.newLine();

  }

  public void streamCalls4() {    
    // Lambda consume a fixed String Stream
    this.mcu().stream().sorted(Comparator.comparing(String::toLowerCase))
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    this.mcu().stream().sorted(Comparator.comparing(String::toLowerCase))
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.methodRefConsumeStr());
    ConsumersFactory.newLine();

  }

  public void streamCalls5() {    
    // Lambda consume a fixed String Stream
    this.mcu().stream().sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    this.mcu().stream().sorted(Comparator.comparing(String::length))
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.methodRefConsumeStr());
    ConsumersFactory.newLine();

  }

  public void streamCalls6() {    
    // Lambda consume a fixed String Stream
    this.mcu().stream().sorted(Comparator.comparing(String::length)
    .thenComparing(Comparator.reverseOrder()))
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.lambdaConsumeStr());
    ConsumersFactory.newLine();
    // Consume a fixed String Stream using Method Expression
    this.mcu().stream().sorted(Comparator.comparing(String::length)
    .thenComparing(Comparator.reverseOrder()))
    .collect(Collectors.toList()).forEach
    (ConsumersFactory.methodRefConsumeStr());
    ConsumersFactory.newLine();
  }

  public List<String> mcu() {
    return Arrays.asList("Iron Man", "The Incredible Hulk",
    "Iron Man 2", "Thor", "Captain America: The First Avenger",
    "Marvel's The Avengers", "Iron Man 3", "Thor: The Dark World",
    "Captain America: The Winter Soldier", "Guardians of the Galaxy",
    "Avengers: Age of Ultron", "Ant-Man", "Captain America: Civil War", "Doctor Strange", "Guardians of the Galaxy Vol. 2",
    "Spider-Man: Homecoming", "Thor: Ragnarok", "Black Panther",
    "Avengers: Infinity War", "Ant-Man and the Wasp", "Captain Marvel", "Avengers: Endgame", "Spider-Man: Far From Home");
  }

  public Stream<Integer> fixedStream() {
    return Stream.of(3, 1, 4, 1, 5, 9);
  }

  public Stream<Integer> addBy(UnaryOperator<Integer> op) {
    return Stream.iterate(1, op);
  }

  public Stream<Double> randomStream() {
    return Stream.generate(Math::random);
  }

  public Consumer<Integer> lambdaConsume() {
    return x -> System.out.print(x + ", ");
  }

  public Consumer<Integer> methodRefConsume() {
    return System.out::print;
  }

  public Consumer<Double> lambdaConsumeDouble() {
    return x -> System.out.print(x + ", ");
  }

  public Consumer<Double> methodRefConsumeDouble() {
    return System.out::print;
  }

  public Consumer<String> lambdaConsumeStr() {
    return x -> System.out.println(x);
  }

  public Consumer<String> methodRefConsumeStr() {
    return System.out::println;
  }

}