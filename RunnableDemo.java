class RunnableDemo {

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