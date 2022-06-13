import java.util.function.Consumer;

public class ConsumersFactory {

  public static void newLine() {
    System.out.println();
  }

  public static Consumer<Integer> lambdaConsume() {
    return x -> System.out.print(x + ", ");
  }

  public static Consumer<Integer> methodRefConsume() {
    return System.out::print;
  }

  public static Consumer<Long> methodRefConsumeLong() {
    return System.out::println;
  }

  public static Consumer<Double> lambdaConsumeDouble() {
    return x -> System.out.print(x + ", ");
  }

  public static Consumer<Double> methodRefConsumeDouble() {
    return System.out::print;
  }

  public static Consumer<String> lambdaConsumeStr() {
    return x -> System.out.println(x);
  }

  public static Consumer<String> methodRefConsumeStr() {
    return System.out::println;
  }

}