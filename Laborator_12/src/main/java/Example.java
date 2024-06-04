public class Example {
    @Test
    public static void testMethod1() {
        System.out.println("testMethod1 executed.");
        System.out.println("Factorial of 5 is: " + factorial(5));
    }

    @Test
    public static void testMethod2() {
        System.out.println("testMethod2 executed.");
        System.out.println("Is 17 a prime number? " + isPrime(17));
    }

    public static void nonTestMethod() {
        System.out.println("nonTestMethod executed.");
        System.out.println("Fibonacci sequence of 10 terms: " + fibonacci(10));
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String fibonacci(int n) {
        int a = 0, b = 1;
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sequence.append(a).append(" ");
            int temp = a;
            a = b;
            b = temp + b;
        }
        return sequence.toString();
    }
}