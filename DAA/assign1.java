/*Write a program non-recursive and recursive program to calculate Fibonacci numbers and
analyze their time and space complexity.*/
import java.util.Scanner;

public class assign1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of 'n' for Fibonacci: ");
        int n = scanner.nextInt();

        // Non-recursive (iterative) Fibonacci
        long startTimeIterative = System.nanoTime();
        long resultIterative = fibonacciIterative(n);
        long endTimeIterative = System.nanoTime();

        System.out.println("Fibonacci(" + n + ") = " + resultIterative);
        System.out.println("Time taken (iterative): " + (endTimeIterative - startTimeIterative) + " nanoseconds");

        // Display Fibonacci series up to n
        System.out.println("Fibonacci Series up to " + n + ":");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacciIterative(i) + " ");
        }

        // Recursive Fibonacci
        long startTimeRecursive = System.nanoTime();
        long resultRecursive = fibonacciRecursive(n);
        long endTimeRecursive = System.nanoTime();

        System.out.println("\nFibonacci(" + n + ") = " + resultRecursive + " (recursive)");
        System.out.println("Time taken (recursive): " + (endTimeRecursive - startTimeRecursive) + " nanoseconds");
        
        // Analyze the time and space complexity of the two approaches
        System.out.println("Time complexity of non-recursive approach: O(n)");
        System.out.println("Space complexity of non-recursive approach: O(1)");
        System.out.println("Time complexity of recursive approach: O(2^n)");
        System.out.println("Space complexity of recursive approach: O(n)");
        
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

    public static long fibonacciRecursive(int n) {
        if (n <= 1)
            return n;

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}





/*
Analysis of time and space complexity:

The time complexity of the non-recursive approach is O(n), because it needs to iterate over the first n Fibonacci numbers to calculate the nth Fibonacci number.
The space complexity of the non-recursive approach is O(1), because it only needs to store a constant number of variables.
The time complexity of the recursive approach is O(2^n), because it needs to make two recursive calls to calculate the nth Fibonacci number.
The space complexity of the recursive approach is O(n), because it needs to store the recursive call stack.
Therefore, the non-recursive approach is more efficient than the recursive approach in terms of both time and space complexity.
*/
