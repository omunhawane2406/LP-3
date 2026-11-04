import java.util.Scanner;

class NQueens {

    static void print(int board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean safe(int board[][], int row, int col, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean solve(int board[][], int row, int n) {
        if (row == n)
            return true;

        for (int col = 0; col < n; col++) {
            if (safe(board, row, col, n)) {
                board[row][col] = 1;

                if (solve(board, row + 1, n))
                    return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        int board[][] = new int[n][n];

        // Place first Queen
        board[0][0] = 1;

        if (solve(board, 1, n)) {
            System.out.println("N-Queens Solution:");
            print(board, n);
        } else {
            System.out.println("Solution does not exist");
        }
    }
}
