import java.util.Scanner;

public class FibonacciIterative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of 'n' for Fibonacci: ");
        int n = scanner.nextInt();
        
        long startTime = System.nanoTime();
        long result = fibonacciIterative(n);
        long endTime = System.nanoTime();

        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Time taken (in nanoseconds): " + (endTime - startTime));

        scanner.close();
    }

    public static long fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        long a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
