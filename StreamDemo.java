import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.function.Consumer;

public class StreamDemo {

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