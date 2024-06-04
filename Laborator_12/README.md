# Laborator 12

### Reflection
Create an application to analyze and test java classes.
The application will receive as input java classes and it will display their prototypes and perform the tests specified by the @Test annotation.

## Compulsory
- The input will be a .class file, located in the classpath of the application. :ballot_box_with_check:
- Load the specified class in memory, assuming its package is known. :ballot_box_with_check:
- Using reflection, extract as many information about the class (at least its methods).   :ballot_box_with_check:
- Using reflection, invoke the static methods, with no arguments, annotated with @Test. :ballot_box_with_check:

### Output

````> Task :ReflectionTestApp.main()
Enter the fully-qualified class name: Example
Methods in class Example:
public static void Example.nonTestMethod()
public static void Example.testMethod2()
public static void Example.testMethod1()
Enter the name of the method to invoke: testMethod2
Invoking: testMethod2
testMethod2 executed.
````

## Homework

- The input may be a class or a folder (containing .class files) or a .jar. You must explore the folders recursively.
- The location of the classes may be anywhere in the file system.
- Create the complete prototype, in the same manner as javap tool.
- Identify all public classes annotated with @Test and invoke the methods annotated with @Test, whether static or not.
- If a method requires primitive (at least int) or String arguments, generate mock values for them.
- Print a statistics regarding the tests.

### Output

```> Task :ReflectionTestApp.main()
Enter the path: D:\Advanced-Programming\Laborator_12\build\classes\java\main
Class: ClassAnalyzer
Modifiers: public
Fields:
Constructors:
  public ClassAnalyzer
Methods:
  private void processClassFile
  public void analyzeAndInvoke
Class: Example
Modifiers: public
Fields:
Constructors:
  public Example
Methods:
  public static void nonTestMethod
  public static void testMethod1
  public static void testMethod2
  public static long factorial
  public static java.lang.String fibonacci
  public static boolean isPrime
testMethod1 executed.
Factorial of 5 is: 120
Invoked: testMethod1
testMethod2 executed.
Is 17 a prime number? true
Invoked: testMethod2
Class: ReflectionTestApp
Modifiers: public
Fields:
Constructors:
  public ReflectionTestApp
Methods:
  public static void main
Class: Test
Modifiers: abstract interface
Fields:
Constructors:
Methods:
```
