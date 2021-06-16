class Main {    

  public static void main(String[] args) {    
    // call 1
    new RunnableDemo().oldWay().start();    
    // call 2
    new RunnableDemo().newWay().start();
    // call 3
    new Thread(new RunnableDemo().newWay2()).start();
  }
}

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