package usaco;

import java.io.*;
import java.util.*;

public class wormhole {
    private static int N;
    private static int[] X = new int[13];
    private static int[] Y = new int[13];
    private static int[] partner = new int[13];
    private static int[] next_on_right = new int[13];
    private static boolean isCycle() {
        for (int start = 1; start <= N; start++) {
            int pos = start;
            for (int count = 0; count < N; count++)
                pos = next_on_right[partner[pos]];
            if (pos != 0)
                return true;
        }
        return false;
    }
    private static int solve() {
        int i, count = 0;
        for (i = 1; i <= N; i++)
            if (partner[i] == 0)
                break;
        if (i > N)
            return isCycle() ? 1 : 0;
        for (int j = i+1; j <= N; j++)
            if (partner[j] == 0) {
                partner[i] = j;
                partner[j] = i;
                count += solve();
                partner[i] = partner[j] = 0;
            }
        return count;

    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("wormhole.in"));
        PrintWriter stdout = new PrintWriter(new File("wormhole.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        N = stdin.nextInt();
        for (int i = 1; i <= N; i++) {
            X[i] = stdin.nextInt();
            Y[i] = stdin.nextInt();
        }
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                if (X[j] > X[i] && Y[i] == Y[j])
                    if (next_on_right[i] == 0 || X[j] < X[next_on_right[i]])
                        next_on_right[i] = j;
        stdout.println(solve());
        stdin.close();
    }
}
