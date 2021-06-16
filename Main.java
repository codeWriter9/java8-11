public class Main {

  public static void threadCalls() {
    // Thread call 
    // call 1
    new RunnableDemo().oldWay().start();    
    // call 2
    new RunnableDemo().newWay().start();
    // call 3
    new Thread(new RunnableDemo().newWay2()).start();
    
  }    

  public static void streamCalls() {
    // Stream 
    StreamDemo streamDemo = new StreamDemo();
    streamDemo.fixedStream().forEach(streamDemo.consume());
    System.out.println();
  }

  public static void main(String[] args) {    
    threadCalls();
    streamCalls();    
  }
}