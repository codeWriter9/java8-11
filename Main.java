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
    // Lambda consume a Stream
    streamDemo.fixedStream().forEach(streamDemo.lambdaConsume());
    System.out.println();
    // Consume a Stream using Method Expression
    streamDemo.fixedStream().forEach(streamDemo.methodRefConsume());  
    System.out.println();
    // Lambda consume a random Stream
    streamDemo.randomStream().limit(5).forEach(streamDemo.lambdaConsumeDouble());
    System.out.println();
    // Consume a random Stream using Method Expression
    streamDemo.randomStream().limit(5).forEach(streamDemo.methodRefConsumeDouble());  
    System.out.println();

  }

  public static void main(String[] args) {    
    threadCalls();
    streamCalls();    
  }
}