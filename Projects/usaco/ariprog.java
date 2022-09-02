package usaco;

import java.io.*;
import java.util.*;

public class ariprog {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("ariprog.in"));
        PrintWriter stdout = new PrintWriter(new File("ariprog.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int n = stdin.nextInt();
        int m = stdin.nextInt();
        boolean[] isBisquare = new boolean[m * m * 2 + 1];
        for (int p = 0; p <= m; p++)
            for (int q = p; q <= m; q++)
                isBisquare[p * p + q * q] = true;
        boolean none = true;
        for (int r = 1; r <= m * m * 2; r++) {
            for (int a = 0; a + r * (n-1) <= m * m * 2; a++) {
                boolean isValid = true;
                for (int b = 0; b < n; b++) {
                    if (a + b * r >= isBisquare.length || !isBisquare[a + b * r]) {
                        isValid = false;
                        b = n;
                    }
                }
                if (isValid) {
                    stdout.println(a + " " + r);
                    none = false;
                }
            }
        }
        if (none)
            stdout.println("NONE");
        stdin.close();
    }
}
