class RunnableDemo {

  private static RunnableDemo demo; 

  public void threadCalls() {
    // Thread call 
    // call 1
    this.oldWay().start();    
    // call 2
    this.newWay().start();
    // call 3
    new Thread(this.newWay2()).start();
  }

  public static RunnableDemo getInstance() {
    if(demo == null) {
      demo = new RunnableDemo();        
    }
    return demo;
  }

  public Thread oldWay() {
    // Inner class 
    return new Thread(new Runnable()
      {
        public void run() {
          System.out.println("Inner class");
        }
      }
    );
  }

  public Thread newWay() {
    // Using Lambda to create a Thread
   return new Thread(() -> System.out.println("Using Lambda"));
  }

  public Runnable newWay2() {
    // Return a runnable 
    return () -> System.out.println("Using Lambda");
  }
}