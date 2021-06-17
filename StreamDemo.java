import java.util.stream.Stream;
import java.util.function.Consumer;

public class StreamDemo {

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
}