package codechef;

import java.util.Scanner;

class MARBLES {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- != 0) {
            int n = 0, k = 0;
            if (stdin.hasNextInt()) {
                n = stdin.nextInt();
            }
            if (stdin.hasNextInt()) {
                k = stdin.nextInt();
            }
            if (n == k) {
                System.out.println(1);
            } else {
                n = n - k;
                long ans = 1;
                for (int i = 1; i < k; i++) {
                    ans = ans * (n + i) / i;
                }
                System.out.println(ans);
            }
        }
    }
}
