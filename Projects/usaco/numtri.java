package usaco;

import java.io.*;
import java.util.*;

public class numtri {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("numtri.in"));
        PrintWriter stdout = new PrintWriter(new File("numtri.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int N = stdin.nextInt();
        int[][] triangle = new int[N][];
        for (int row = 0; row < N; row++) {
            triangle[row] = new int[row+1];
            for (int col = 0; col <= row; col++) {
                triangle[row][col] = stdin.nextInt();
            }
        }
        for (int row = N - 2; row >= 0; row--)
            for (int col = 0; col < triangle[row].length; col++)
                triangle[row][col] += Math.max(triangle[row+1][col], triangle[row+1][col+1]);
        stdout.println(triangle[0][0]);
        stdin.close();
    }
}
