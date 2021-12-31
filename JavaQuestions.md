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
