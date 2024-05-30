import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
}

public class ClassAnalyzer {

    public void analyzeAndInvoke(String className, Scanner scanner) {
        try {
            // Load the class
            Class<?> clazz = Class.forName(className);

            // Extract and display methods
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Methods in class " + className + ":");
            for (Method method : methods) {
                System.out.println(method);
            }

            // Prompt user for method to invoke
            System.out.print("Enter the name of the method to invoke: ");
            String methodName = scanner.nextLine();

            boolean methodFound = false;

            for (Method method : methods) {
                if (method.getName().equals(methodName) &&
                        method.isAnnotationPresent(Test.class) &&
                        java.lang.reflect.Modifier.isStatic(method.getModifiers()) &&
                        method.getParameterCount() == 0) {
                    try {
                        System.out.println("Invoking: " + method.getName());
                        method.invoke(null);
                        methodFound = true;
                        break;
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.err.println("Failed to invoke method: " + method.getName());
                        e.printStackTrace();
                    }
                }
            }

            if (!methodFound) {
                System.err.println("Method not found or not suitable for invocation.");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
            e.printStackTrace();
        }
    }
}
