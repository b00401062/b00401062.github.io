package usaco;

import java.io.*;
import java.util.*;

public class frac1 {
    private static PrintWriter stdout;
    private static int n;
    private static void generateFrac(int n1, int d1, int n2, int d2) {
        if (d1 + d2 > n)
            return;
        generateFrac(n1, d1, n1 + n2, d1 + d2);
        stdout.println((n1 + n2) + "/" + (d1 + d2));
        generateFrac(n1 + n2, d1 + d2, n2, d2);
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("frac1.in"));
        stdout = new PrintWriter(new File("frac1.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        n = stdin.nextInt();
        stdout.println("0/1");
        generateFrac(0, 1, 1, 1);
        stdout.println("1/1");
        stdin.close();
    }
}
