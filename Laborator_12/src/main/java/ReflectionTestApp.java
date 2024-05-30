import java.util.Scanner;

public class ReflectionTestApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the fully-qualified class name: ");
        String className = scanner.nextLine();

        ClassAnalyzer analyzer = new ClassAnalyzer();
        analyzer.analyzeAndInvoke(className, scanner);
    }
}
