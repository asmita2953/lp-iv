import java.util.Scanner;

public class assign5 {

    private static int N = 8;

    public static void solve() {
        int[][] board = new int[N][N];
        boolean[] col = new boolean[N];
        boolean[] dia1 = new boolean[2 * N - 1];
        boolean[] dia2 = new boolean[2 * N - 1];

        placeQueen(board, col, dia1, dia2, 0);
    }

    private static void placeQueen(int[][] board, boolean[] col, boolean[] dia1, boolean[] dia2, int row) {
        if (row == N) {
            printBoard(board);
            return;
        }

        for (int colIndex = 0; colIndex < N; colIndex++) {
            int dia1Index = row + colIndex;
            int dia2Index = N - 1 + row - colIndex;

            if (!col[colIndex] && !dia1[dia1Index] && !dia2[dia2Index]) {
                board[row][colIndex] = 1;
                col[colIndex] = true;
                dia1[dia1Index] = true;
                dia2[dia2Index] = true;

                placeQueen(board, col, dia1, dia2, row + 1);

                board[row][colIndex] = 0;
                col[colIndex] = false;
                dia1[dia1Index] = false;
                dia2[dia2Index] = false;
            }
        }
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int n = scanner.nextInt();
        System.out.println();

        N = n;
        solve();
    }
}