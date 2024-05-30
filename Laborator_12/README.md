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