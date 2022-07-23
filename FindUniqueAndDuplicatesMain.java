import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


public class FindUniqueAndDuplicatesMain {        
  
  public static void main(String[] args) 
  throws InterruptedException {                  
     long start = System.currentTimeMillis();
    
     Predicate<Map.Entry<Integer, Long>> unique = e -> e.getValue() == 1;
     Predicate<Map.Entry<Integer, Long>> duplicate = e -> e.getValue() > 1;
    
     System.out.println(
       Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5).stream()       
       .collect(Collectors.groupingBy(
           Function.identity(), Collectors.counting()
         )
       ).entrySet().stream().filter(unique)
       .map(Map.Entry::getKey).collect(Collectors.toList())
     );

     System.out.println(
       Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5).stream()       
       .collect(Collectors.groupingBy(
           Function.identity(), Collectors.counting()
         )
       ).entrySet().stream().filter(duplicate)
       .map(Map.Entry::getKey).collect(Collectors.toList())
     );
     long end = System.currentTimeMillis();
     StringBuilder builder = new StringBuilder("Time Taken = ");
     builder.append((end - start));
     builder.append(" ms");
     System.out.println(builder.toString());
  }
}
