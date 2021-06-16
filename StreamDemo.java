import java.util.stream.*;
import java.util.function.*;

public class StreamDemo {
  public Stream fixedStream() {
    return Stream.of(3, 1, 4, 1, 5, 9);
  }

  public Consumer<Integer> consume() {
    return x -> System.out.print(x + ", ");
  }
}