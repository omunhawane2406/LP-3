import java.util.Scanner;

class Knapsack {

    static void knapsack(int n, int m, int p[], int w[]) {
        double total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((double) p[i] / w[i] < (double) p[j] / w[j]) {
                    int temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;

                    temp = w[i];
                    w[i] = w[j];
                    w[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (m >= w[i]) {
                m = m - w[i];
                total = total + p[i];
            } else {
                total = total + (double) p[i] * m / w[i];
                break;
            }
        }

        System.out.println("Maximum Profit = " + total);
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

        System.out.print("Enter knapsack capacity: ");
        int m = sc.nextInt();

        knapsack(n, m, p, w);
    }
}
