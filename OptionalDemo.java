import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class OptionalDemo {

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