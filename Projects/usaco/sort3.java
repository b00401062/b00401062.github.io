package usaco;

import java.io.*;
import java.util.*;

public class sort3 {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("sort3.in"));
        PrintWriter stdout = new PrintWriter(new File("sort3.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int n = stdin.nextInt();
        int[] seq = new int[n];
        int[] sc = new int[4];
        for (int i = 0; i < n; i++)
            sc[(seq[i] = stdin.nextInt())]++;
        int s12 = 0, s13 = 0, s21 = 0, s31 = 0, s23 = 0, s32 = 0;
        for (int i = 0; i < sc[1]; i++){
            if (seq[i] == 2) s12++;
            if (seq[i] == 3) s13++;
        }
        for (int i = sc[1]; i < sc[1] + sc[2]; i++){
            if (seq[i] == 1) s21++;
            if (seq[i] == 3) s23++;
        }
        for (int i = sc[1] + sc[2]; i < sc[1] + sc[2] + sc[3]; i++){
            if (seq[i] == 1) s31++;
            if (seq[i] == 2) s32++;
        }
        stdout.println(Math.min(s12, s21) + Math.min(s13, s31) + Math.min(s23, s32) + 2 * Math.abs(s12 - s21));
        stdin.close();
    }
}
