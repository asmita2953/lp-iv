//Write a program to solve a 0-1 Knapsack problem using dynamic programming or branch and bound strategy.
import java.util.Scanner;


public class Main {

    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for item " + (i + 1) + ":");
            System.out.print("Weight: ");
            weights[i] = scanner.nextInt();
            System.out.print("Value: ");
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        int maxValue = knapsack(capacity, weights, values, n);

        System.out.println("Maximum value that can be obtained = " + maxValue);

        scanner.close();
    }
}

