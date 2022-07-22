import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


class AllTheLetters {        
  
  public static void main(String[] args) 
  throws InterruptedException {                  
     long start = System.currentTimeMillis();    
     System.out.println("The quick brown fox jumps over the lazy dog"
     .toLowerCase()
     .replace(" ", "")
     .chars().distinct().count() == 26); 
     long end = System.currentTimeMillis();
     StringBuilder builder = new StringBuilder("Time Taken = ");
     builder.append((end - start));
     builder.append(" ms");
     System.out.println(builder.toString());
  }
}
