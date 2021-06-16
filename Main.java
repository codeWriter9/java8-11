class Main {    

  public static void main(String[] args) {    
    // Old way
    new RunnableDemo().oldWay().start();    
   // New way
   new RunnableDemo().newWay().start();
  }
}

class RunnableDemo {

  public Thread oldWay() {
    // Old way
    return new Thread(new Runnable()
      {
        public void run() {
          System.out.println("Inner class");
        }
      }
    );
  }

  public Thread newWay() {
    // New way
   return new Thread(() -> System.out.println("Using Lambda"));
  }
}