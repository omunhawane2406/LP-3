import java.util.Scanner;

class Knapsack {

    static void knapsack(int n, int m, int p[], int w[]) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(
                        p[i - 1] + dp[i - 1][j - w[i - 1]],
                        dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Maximum Profit = " + dp[n][m]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int p[] = new int[n];
        int w[] = new int[n];

        System.out.println("Enter profits:");
        for (int i = 0; i < n; i++)
            p[i] = sc.nextInt();

        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++)
            w[i] = sc.nextInt();

        System.out.print("Enter capacity: ");
        int m = sc.nextInt();

        knapsack(n, m, p, w);
    }
}
