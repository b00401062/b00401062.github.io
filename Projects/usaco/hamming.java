package usaco;

import java.io.*;
import java.util.*;

public class hamming {
    private static int N;
    private static int B;
    private static int D;
    private static int[][] dist;
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("hamming.in"));
        PrintWriter stdout = new PrintWriter(new File("hamming.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        N = stdin.nextInt();
        B = stdin.nextInt();
        D = stdin.nextInt();
        dist = new int[1 << B][1 << B];
        for (int i = 0; i < (1 << B); i++)
            for (int j = i+1; j < (1 << B); j++)
                for (int s = 0; s < B; s++)
                    if (((i ^ j) & (1 << s)) != 0)
                        dist[i][j] = ++dist[j][i];
        List<Integer> codes = new ArrayList<Integer>(N);
        codes.add(0);
        for (int i = 1; i < (1 << B) && codes.size() < N; i++) {
            boolean valid = true;
            for (int j = 0; j < codes.size(); j++)
                if (dist[codes.get(j)][i] < D) {
                    valid = false;
                    break;
                }
            if (valid)
                codes.add(i);
        }
        for (int i = 0; i < N; i++) {
            stdout.print(codes.get(i));
            stdout.print(i % 10 == 9 || i == N-1 ? '\n' : ' ');
        }
        stdin.close();
    }
}
