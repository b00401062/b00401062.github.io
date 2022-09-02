package usaco;

import java.io.*;
import java.util.*;

public class milk2 {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("milk2.in"));
        PrintWriter stdout = new PrintWriter(new File("milk2.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int N = stdin.nextInt();
        int[][] farmers = new int[N][2];
        for (int i = 0; i < N; i++) {
            farmers[i][0] = stdin.nextInt();
            farmers[i][1] = stdin.nextInt();
        }
        Arrays.sort(farmers, Comparator.comparingInt(a -> a[0]));
        int max_idle = 0, max_work = 0, ts = farmers[0][0], te = farmers[0][1];
        for (int i = 1; i < N; i++) {
            if (te < farmers[i][0]) {
                max_idle = Math.max(max_idle, farmers[i][0] - te);
                max_work = Math.max(max_work, te - ts);
                ts = farmers[i][0];
                te = farmers[i][1];
            } else {
                te = Math.max(te, farmers[i][1]);
            }
        }
        max_work = Math.max(max_work, te - ts);
        stdout.println(max_work + " " + max_idle);
        stdin.close();
    }
}
