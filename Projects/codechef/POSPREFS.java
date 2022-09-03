package codechef;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class POSPREFS {
    private static double formula(int x) {
        return (Math.sqrt(1 + 4 * x) - 1) / 2;
    }

    private static int[] solve(int n, int k) {
        int[] a = new int[n + 1];
        int m = k == n ? n : (int) formula((k + 1) * (k + 2) / 2);
        for (int i = 1; i <= m; i++) {
            a[i] = i;
        }
        for (int i = m + 1; i <= n; i++) {
            a[i] = -i;
        }
        if (m * m + m <= k * (k + 1) / 2) {
            a[k + 1] = k + 1;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int k = stdin.nextInt();
            int[] a = solve(n, k);
            System.out.println(
                    Arrays
                            .stream(a)
                            .skip(1)
                            .mapToObj(Integer::toString)
                            .collect(Collectors.joining(" "))
            );
        }
        stdin.close();
    }
}
