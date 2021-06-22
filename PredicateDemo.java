import java.util.function.Predicate;

public class PredicateDemo {  
  
  public static Predicate<String> batman = movie ->
  movie.contains("Batman") || movie.contains("Dark Knight");

  public static Predicate<String> spiderman = movie ->
  movie.contains("Spideman") || movie.contains("home")
  || movie.contains("Home");

}