package usaco;

import java.io.*;
import java.util.*;

public class concom {
    private static final int MAX = 100;
    private static int[][] table = new int[MAX + 1][MAX + 1];
    private static int[] counts;
    private static boolean[] visited;
    private static void visit(int i) {
        visited[i] = true;
        for (int j = 1; j <= MAX; j++)
            counts[j] += table[i][j];
        for (int j = 1; j <= MAX; j++)
            if (counts[j] > 50 && !visited[j])
                visit(j);
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("concom.in"));
        PrintWriter stdout = new PrintWriter(new File("concom.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int N = stdin.nextInt();
        for (int n = 0; n < N; n++)
            table[stdin.nextInt()][stdin.nextInt()] = stdin.nextInt();
        for (int i = 1; i <= MAX; i++) {
            counts = new int[MAX + 1];
            visited = new boolean[MAX + 1];
            visit(i);
            for (int j = 1; j <= MAX; j++)
                if (counts[j] > 50 && j != i)
                    stdout.println(i + " " + j);
        }
        stdin.close();
    }
}
