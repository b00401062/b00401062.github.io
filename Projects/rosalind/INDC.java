package rosalind;

import java.io.*;
import java.util.*;

public class INDC {
    private static double choose(int N, int k) {
        double x = 1;
        for (int i = N; i > N - k; i--)
            x *= i;
        for (int i = k; i > 0; i--)
            x /= i;
        return x;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        for (int k = 1; k <= 2 * n; k++) {
            double p = 0;
            for (int i = k; i <= 2 * n; i++)
                p += choose(2 * n, i) * Math.pow(0.5, 2 * n);
            System.out.printf("%.3f\n", Math.log10(p));
        }
        stdin.close();
    }
}
