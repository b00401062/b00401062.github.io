package usaco;

import java.io.*;
import java.util.*;

public class barn1 {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("barn1.in"));
        PrintWriter stdout = new PrintWriter(new File("barn1.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int M = stdin.nextInt();
        stdin.nextInt();
        final int C = stdin.nextInt();
        if (M >= C) {
            stdout.println(C);
            System.exit(0);
        }
        int[] cows = new int[C];
        for (int i = 0; i < C; i++)
            cows[i] = stdin.nextInt();
        Arrays.sort(cows);
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(C-1, (a, b) -> b[1] - a[1]);
        for (int i = 1; i < C; i++)
            heap.add(new int[] { i, cows[i] - cows[i-1] });
        int[] breakpoint = new int[M+1];
        for (int i = 1; i < M; i++)
            breakpoint[i] = heap.poll()[0];
        breakpoint[M] = C;
        Arrays.sort(breakpoint);
        int count = 0;
        for (int i = 1; i < breakpoint.length; i++)
            count += cows[breakpoint[i]-1] - cows[breakpoint[i-1]] + 1;
        stdout.println(count);
        stdin.close();
    }
}
