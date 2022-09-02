package usaco;

import java.io.*;
import java.util.*;

public class money {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("money.in"));
        PrintWriter stdout = new PrintWriter(new File("money.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int V = stdin.nextInt();
        int N = stdin.nextInt();
        int[] coins = new int[V];
        for (int v = 0; v < V; v++)
            coins[v] = stdin.nextInt();
        stdin.close();
        int[] counts = new int[N + 1];
        counts[0] = 1;
        for (int v = 0; v < V; v++)
            for (int n = coins[v]; n <= N; n++)
                counts[n] += counts[n - coins[v]];
        stdout.println(counts[N]);
    }
}
