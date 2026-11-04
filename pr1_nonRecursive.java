class Fibonacci {
    public static void main(String[] args) {
        int n = 7;
        int a = 0, b = 1, c;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            c = a + b;
            a = b;
            b = c;
        }
    }
}
