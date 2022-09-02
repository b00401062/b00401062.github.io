package usaco;

import java.io.*;
import java.util.*;

public class nocows {
    public static int evaluate(int N, int K) {
        if (N % 2 == 0 || N >= (int) Math.pow(2, K))
            return 0;
        int[][] table = new int[N + 1][K + 1];
        table[1][1] = 1;
        for (int n = 3; n <= N; n += 2)
            for (int k = 1; k <= K; k++) {
                for (int i = 1; i <= (n - 2) / 2; i += 2) {
                    int sum1 = Arrays.stream(Arrays.copyOfRange(table[n - i - 1], 0, k)).sum() % 9901;
                    int sum2 = Arrays.stream(Arrays.copyOfRange(table[i], 0, k)).sum() % 9901;
                    table[n][k] += (sum1 * sum2 - (sum1 - table[n - i - 1][k - 1]) * (sum2 - table[i][k - 1])) * 2;
                }
                if (n % 4 == 3) {
                    int sum = Arrays.stream(Arrays.copyOfRange(table[n / 2], 0, k)).sum() % 9901;
                    table[n][k] += sum * sum - (sum - table[n / 2][k - 1]) * (sum - table[n / 2][k - 1]);
                }
                table[n][k] %= 9901;
            }
        return table[N][K] % 9901;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("nocows.in"));
        PrintWriter stdout = new PrintWriter(new File("nocows.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int N = stdin.nextInt();
        final int K = stdin.nextInt();
        stdin.close();
        stdout.println(evaluate(N, K));
    }
}
