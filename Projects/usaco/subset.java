package usaco;

import java.io.*;
import java.util.*;

public class subset {
    private static int N;
    private static long countSubset(int sum) {
        long[][] dict = new long[N + 1][sum + 1];
        for (int i = 0; i <= N; i++)
            dict[i][0] = 1;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= sum; j++)
                dict[i][j] = dict[i - 1][j] + (j - i < 0 ? 0 : dict[i - 1][j - i]);
        return dict[N][sum];
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("subset.in"));
        PrintWriter stdout = new PrintWriter(new File("subset.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        N = stdin.nextInt();
        final int sum = N * (N + 1) / 2;
        stdout.println(sum % 2 == 0 ? countSubset(sum / 2) / 2 : 0);
        stdin.close();
    }
}
