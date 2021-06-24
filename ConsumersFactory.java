import java.util.function.Consumer;

public class ConsumersFactory {
    public Consumer<Integer> lambdaConsume() {
    return x -> System.out.print(x + ", ");
  }

  public Consumer<Integer> methodRefConsume() {
    return System.out::print;
  }

  public Consumer<Long> methodRefConsumeLong() {
    return System.out::println;
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