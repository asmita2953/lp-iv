import java.util.Scanner;

public class project_approx {

    public static void main(String[] args) {

        // Prompt the user to enter the number of cities
        System.out.println("Enter the number of cities: ");
        Scanner scanner = new Scanner(System.in);
        int numCities = scanner.nextInt();

        // Validate the user input
        if (numCities < 2) {
            System.out.println("The number of cities must be at least 2.");
            return;
        }

        // Create a distance matrix between the cities
        int[][] distances = new int[numCities][numCities];
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                // Prompt the user to enter the distance between city i and city j
                System.out.println("Enter the distance between city " + i + " and city " + j + ": ");
                distances[i][j] = scanner.nextInt();
            }
        }

        // Validate the distance matrix
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                if (distances[i][j] < 0) {
                    System.out.println("The distance between city " + i + " and city " + j + " must be non-negative.");
                    return;
            }
        }

        // Solve the TSP
        int[] tour = solveTSP(distances);

        // Print the tour
        System.out.println("The nearest neighbor tour is:");
        for (int i = 0; i < tour.length; i++) {
            System.out.print(tour[i] + " ");
        }
        System.out.println();
    }

    private static int[] solveTSP(int[][] distances) {

        // Create a tour
        int[] tour = new int[distances.length];

        // Initialize the tour
        tour[0] = 0;
        for (int i = 1; i < distances.length; i++) {
            tour[i] = -1;
        }

        // Visit each city in the nearest neighbor order
        for (int i = 1; i < distances.length; i++) {
            int currentCity = tour[i - 1];
            int nextCity = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int j = 0; j < distances.length; j++) {
                if (distances[currentCity][j] > 0 && distances[currentCity][j] < shortestDistance && !contains(tour, j)) {
                    shortestDistance = distances[currentCity][j];
                    nextCity = j;
                }
            }
            tour[i] = nextCity;
        }

        // Return the tour
        return tour;
    }

    private static boolean contains(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }
}
