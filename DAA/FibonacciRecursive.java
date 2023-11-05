import java.util.Scanner;

public class FibonacciRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of 'n' for Fibonacci: ");
        int n = scanner.nextInt();

        long startTime = System.nanoTime();
        long result = fibonacciRecursive(n);
        long endTime = System.nanoTime();

        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Time taken (in nanoseconds): " + (endTime - startTime));

        scanner.close();
    }

    public static long fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
