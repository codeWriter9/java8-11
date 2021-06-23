public class StringDemo {

  public String repeatCaller(String prefix, Integer count, String suffix) {    
    return prefix.repeat(count) + suffix;
  }

  public String repeatCaller(String prefix, String suffix) {    
    return repeatCaller(prefix, 0, suffix);
  }

  public String stripCaller(String withBlanks) {
    return withBlanks.strip();
  }

  public Long countLines(String multilineStr) {   
    return multilineStr.lines().count();    
  }

}