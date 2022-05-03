# Java Interview Questions
Java Interview Questions


## 1. What are the different design patterns implemented in Java ?
* Abstract Factory - Recognizeable by creational methods returning the factory itself which in turn can be used to create another abstract/interface type
another abstract/interface type
  * [javax.xml.parsers.DocumentBuilderFactory#newInstance()](https://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilderFactory.html#newInstance())  
  * [javax.xml.xpath.XPathFactory#newInstance()](https://docs.oracle.com/javase/7/docs/api/javax/xml/xpath/XPathFactory.html#newInstance())
* Adapter - Recognizeable by creational methods taking an instance of different abstract/interface type and returning an implementation of own/another abstract/interface type which decorates/overrides the given instance
  * [java.util.Arrays.html#asList(T...)](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html#asList(T...))  
  * [java.util.Collections#list()](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#list-java.util.Enumeration-)
* Builder - Recognizeable by creational methods returning the instance itself
  * [java.lang.StringBuilder.append()](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html#append-boolean-)  
  * [java.lang.StringBuffer.append()](https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuffer.html#append(boolean))

   
   
## 2. How can you access Super Interface default methods ?
  It can be accessed in a subclass or a subinterface via &lt;SuperInterface&gt;.super.&lt;method&gt;

   

## 3. What is the difference between POST, PUT and PATCH methods ?
* POST - This is a REST method used for creating a new resource. If the resource already exists a new possibly duplicate resource would be created. [rfc2616](https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html#sec9.5)
* PUT - This is a REST method used to update a resource if that exists or create a new one if it doesn't. [rfc2616](https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html#sec9.6)
* PATCH - This is a REST method used to update a resource. [rfc2068](https://www.rfc-editor.org/rfc/rfc2068)

# 4. What is the difference between URI, URL and URN ?
* URI - Uniform Resource Identifier - A collection or string of characters that uniquely identify a name or a resource on internet
* URL - Uniform Resource Locator - A type of URI that specifies how to reach a resource on internet
* URN - Uniform Resource Name - A type of URI that uses the special naming convention of URN
   
[URI java docs](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)
