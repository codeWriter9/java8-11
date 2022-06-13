public class StringDemo {

  private static StringDemo stringDemo;

  public static StringDemo getInstance() {
    if(stringDemo == null) {
      stringDemo = new StringDemo();
    }
    return stringDemo;
  }

  public void stringCalls() {    
    ConsumersFactory.lambdaConsumeStr().accept(repeatCaller("La ", 2, "Land"));
    ConsumersFactory.lambdaConsumeStr().accept(repeatCaller("No Man's", "Land"));
    ConsumersFactory.lambdaConsumeStr().accept(">>" + stripCaller("     without Blanks   ") + "<<");
    ConsumersFactory.methodRefConsumeLong().accept(countLines("This is\nA Multi Line Comment\n."));
  }

  public String repeatCaller(String prefix, Integer count, String suffix) {    
    return prefix.repeat(count) + suffix;
  }

  public String repeatCaller(String prefix, String suffix) {    
    return repeatCaller(prefix, 0, suffix);
  }

  public String stripCaller(String withBlanks) {
    return withBlanks.strip();
  }

  public Long countLines(String multilineStr) {   
    return multilineStr.lines().count();    
  }

}