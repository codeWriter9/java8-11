public class Main {    

  public static void main(String[] args) {    
    RunnableDemo.getInstance().threadCalls();
    StreamDemo.getInstance().streamCalls();
    StreamDemo.getInstance().streamCalls2();
    StreamDemo.getInstance().streamCalls3();
    StreamDemo.getInstance().streamCalls4();
    StreamDemo.getInstance().streamCalls5();
    StreamDemo.getInstance().streamCalls6();
    OptionalDemo.getInstance().optionalCalls();
    OptionalDemo.getInstance().optionalCalls2();
    StringDemo.getInstance().stringCalls();
    DateTimeDemo.getInstance().timeDemoCalls();
    DateTimeDemo.getInstance().timeDemoCalls2();
  }
}