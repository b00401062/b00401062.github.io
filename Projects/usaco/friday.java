package usaco;

import java.io.*;
import java.util.*;

public class friday {
    private static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("friday.in"));
        PrintWriter stdout = new PrintWriter(new File("friday.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int[] counter = new int[7];
        int N = stdin.nextInt();
        int dow = 0;
        for(int year = 1900; year < 1900 + N; year++) {
            int[] dpw = { 31, 28 + (isLeap(year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            for(int month = 0; month < 12; month++) {
                counter[dow]++;
                dow = (dow + dpw[month]) % 7;
            }
        }
        for(int i = 0; i < 7; i++) {
            stdout.print(counter[i]);
            stdout.print(i == 6 ? '\n' : ' ');
        }
        stdin.close();
    }
}
