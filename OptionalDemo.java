import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;



public class OptionalDemo {

  private static OptionalDemo optionalDemo;

  public static OptionalDemo getInstance() {
    if(optionalDemo == null) {
      optionalDemo = new OptionalDemo();
    }
    return optionalDemo;
  }

  public void optionalCalls() {    
    // Consume only if present or show that value is not there
    ConsumersFactory.lambdaConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).orElse("Value Not Present"));
    ConsumersFactory.lambdaConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).orElse("Value Not Present"));

    ConsumersFactory.methodRefConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).orElse("Value Not Present"));
    ConsumersFactory.methodRefConsumeStr().accept(optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).orElse("Value Not Present"));
  }

  public void optionalCalls2() {    
    // Consume only if present 
    optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).ifPresent(ConsumersFactory.lambdaConsumeStr());
    optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).ifPresent(ConsumersFactory.lambdaConsumeStr());
    optionalDemo.findFirst(PredicateDemo.batman, optionalDemo.mcu()).ifPresent(ConsumersFactory.methodRefConsumeStr());
    optionalDemo.findFirst(PredicateDemo.spiderman, optionalDemo.mcu()).ifPresent(ConsumersFactory.methodRefConsumeStr());
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