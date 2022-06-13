import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class OptionalDemo {

  private static OptionalDemo optionalDemo;

  public static OptionalDemo getInstance() {
    if(optionalDemo == null) {
      optionalDemo = new OptionalDemo();
    }
    return optionalDemo;
  }

  public void optionalCalls(ConsumersFactory consumer) {    
    // Consume only if present or show that value is not there
    consumer.lambdaConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).orElse("Value Not Present"));
    consumer.lambdaConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).orElse("Value Not Present"));

    consumer.methodRefConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).orElse("Value Not Present"));
    consumer.methodRefConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).orElse("Value Not Present"));
  }

  public void optionalCalls2(ConsumersFactory consumer) {    
    // Consume only if present 
    optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).ifPresent(consumer.lambdaConsumeStr());
    optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).ifPresent(consumer.lambdaConsumeStr());
    optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).ifPresent(consumer.methodRefConsumeStr());
    optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).ifPresent(consumer.methodRefConsumeStr());
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

  public Optional<String> findFirst(Predicate<String> predicate, 
    List<String> list) {
      return list.stream().filter(predicate).findFirst();
    }

  
}