import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


class PrimesTill100Main {        
  
  public static void main(String[] args) 
  throws InterruptedException {                  
     long start = System.currentTimeMillis();    
     System.out.println(Stream.concat(Arrays.asList(2, 3, 5, 7, 11).stream(),Stream.iterate(12, x -> x + 1).limit(100).filter(x -> x < 101).filter(x -> Arrays.asList(2, 3, 5, 7, 11).stream().allMatch(prime -> x % prime != 0))).sorted().collect(Collectors.toList())); 
     long end = System.currentTimeMillis();
     StringBuilder builder = new StringBuilder("Time Taken = ");
     builder.append((end - start));
     builder.append(" ms");
     System.out.println(builder.toString());
  }
}
