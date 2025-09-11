# 99 Java Problems :coffee:
Following the [99 Java Problems](https://tech.tonyballantyne.com/java/99-java-problems/) course, to get a hold of java core before getting to mangled with Spring or other framework dependent details

## Loading the code
- We can use the Java Shell for loading the code, in a command line just run:
```bash
$> $JAVA_HOME/bin/jshell
```
- Then inside the repl, open the desired file:
```bash
jshell> /open lesson1.java
```
- Check the functions were loaded with `/methods`:
```java
jshell> /methods
|    void main()
|    void hello(String)
|    double average(double,double)
```
> Alternatively you can directly pass the file, and jshell may by in PATH
```bash
$> jshell lesson1.java
```

### Exceptions to the rule
- Some problems require interactive input, like [2.7 Are we there yet?](./lesson2.java). In this case, just run the file such that the `main` function will invoke that code.