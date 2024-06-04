import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
}

public class ClassAnalyzer {
    public void analyzeAndInvoke(String inputPath) {
        File inputFile = new File(inputPath);
        if (inputFile.isDirectory()) {
            // Process all .class files in the directory
            for (File file : inputFile.listFiles()) {
                if (file.isDirectory()) {
                    analyzeAndInvoke(file.getPath());
                } else if (file.getName().endsWith(".class")) {
                    processClassFile(file, inputPath);
                }
            }
        } else if (inputFile.getName().endsWith(".jar")) {
            // Process all .class files in the .jar file
            try (JarFile jarFile = new JarFile(inputFile)) {
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();
                    if (entry.getName().endsWith(".class")) {
                        processClassFile(new File(entry.getName()), inputPath);
                    }
                }
            } catch (IOException e) {
                System.err.println("Failed to process .jar file: " + inputFile);
                e.printStackTrace();
            }
        } else if (inputFile.getName().endsWith(".class")) {
            // Process the single .class file
            processClassFile(inputFile, inputPath);
        } else {
            System.err.println("Invalid input file: " + inputFile);
        }
    }


    private void processClassFile(File classFile, String inputPath) {
        try {

            URL classUrl = classFile.toURI().toURL();
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{classUrl});
            String className = classFile.getName().substring(0, classFile.getName().length() - 6);


            String filePath = classFile.getAbsolutePath();
            String basePath = new File(inputPath).getAbsolutePath();
            String packageName = filePath.substring(basePath.length() + 1, filePath.length() - classFile.getName().length());
            packageName = packageName.replace(File.separator, ".");

            Class<?> clazz = Class.forName(className, true, classLoader);


            System.out.println("Class: " + clazz.getName());
            System.out.println("Modifiers: " + Modifier.toString(clazz.getModifiers()));


            Field[] fields = clazz.getDeclaredFields();
            System.out.println("Fields:");
            for (Field field : fields) {
                System.out.println("  " + Modifier.toString(field.getModifiers()) + " " + field.getType().getName() + " " + field.getName());
            }


            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + Modifier.toString(constructor.getModifiers()) + " " + constructor.getName());
            }


            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println("  " + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName());
            }


            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    try {
                        Object[] args = new Object[method.getParameterCount()];
                        for (int i = 0; i < method.getParameterCount(); i++) {
                            Class<?> paramType = method.getParameterTypes()[i];
                            if (paramType.isPrimitive()) {
                                if (paramType.equals(int.class)) {
                                    args[i] = 0;
                                } else {
                                    args[i] = 0;
                                }
                            } else if (paramType.equals(String.class)) {
                                args[i] = "";
                            } else {
                                args[i] = null;
                            }
                        }
                        method.invoke(clazz.newInstance(), args);
                        System.out.println("Invoked: " + method.getName());
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        System.err.println("Failed to invoke method: " + method.getName());
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to process class file: " + classFile);
            e.printStackTrace();
        }
    }
}

