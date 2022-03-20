package usaco;

import java.io.*;
import java.util.*;

public class combo {
    private static int N;
    private static boolean isClose(int[] a, int[] b) {
        for (int i = 0; i < 3; i++)
            if (Math.abs(a[i] - b[i]) > 2 && Math.abs(a[i] - b[i]) < N-2)
                return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("combo.in"));
        PrintWriter stdout = new PrintWriter(new File("combo.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        N = stdin.nextInt();
        int[] fkey = new int[3];
        int[] mkey = new int[3];
        for (int i = 0; i < 3; i++)
            fkey[i] = stdin.nextInt();
        for (int i = 0; i < 3; i++)
            mkey[i] = stdin.nextInt();
        int count = 0;
        for (int d1 = 1; d1 <= N; d1++)
            for (int d2 = 1; d2 <= N; d2++)
                for (int d3 = 1; d3 <= N; d3++) {
                    int[] combo = new int[] { d1, d2, d3 };
                    if (isClose(combo, fkey) || isClose(combo, mkey))
                        count++;
                }
        stdout.println(count);
        stdin.close();
    }
}
