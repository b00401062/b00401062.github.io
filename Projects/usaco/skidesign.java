package usaco;

import java.io.*;
import java.util.*;

public class skidesign {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("skidesign.in"));
        PrintWriter stdout = new PrintWriter(new File("skidesign.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int N = stdin.nextInt();
        int[] hills = new int[N];
        for (int i = 0; i < N; i++)
            hills[i] = stdin.nextInt();
        Arrays.sort(hills);
        int cost_min = Integer.MAX_VALUE;
        for (int i = 0; i <= 83; i++) {
            int cost = 0;
            for (int j = 0; j < N; j++) {
                int diff = 0;
                if (hills[j] < i)
                    diff = i - hills[j];
                else if (hills[j] > i + 17)
                    diff = hills[j] - (i + 17);
                cost += diff * diff;
            }
            cost_min = Math.min(cost_min, cost);
        }
        stdout.println(cost_min);
        stdin.close();
    }
}
