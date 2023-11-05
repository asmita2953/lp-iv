// Write a program to solve a fractional Knapsack problem using a greedy method.
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FracktionalKnapsack {

    public static double fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble(item -> (double) item.value / item.weight));

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (int i = items.length - 1; i >= 0; i--) {
            if (remainingCapacity >= items[i].weight) {
                totalValue += items[i].value;
                remainingCapacity -= items[i].weight;
            } else {
                double fraction = (double) remainingCapacity / items[i].weight;
                totalValue += fraction * items[i].value;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for item " + (i + 1) + ":");
            System.out.print("Weight: ");
            int weight = scanner.nextInt();
            System.out.print("Value: ");
            int value = scanner.nextInt();

            items[i] = new Item(weight, value);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        double maxValue = fractionalKnapsack(capacity, items);

        System.out.println("Maximum value that can be obtained = " + maxValue);

        scanner.close();
    }
}

