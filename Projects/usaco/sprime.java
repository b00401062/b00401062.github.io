package usaco;

import java.io.*;
import java.util.*;

public class sprime {
    private static PrintWriter stdout;
    private static boolean isPrime(int n) {
        if (n == 2)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
    private static void solve(int current, int n) {
        if(!isPrime(current))
              return;
        int current_len = (current == 0) ? 0 : String.valueOf(current).length();
        if (current_len == n)
            stdout.println(current);
        else for (int i : new int[] { 1, 3, 5, 7, 9 })
            solve(10 * current + i, n);
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("sprime.in"));
        stdout = new PrintWriter(new File("sprime.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int n = stdin.nextInt();
        for (int i : new int[] { 2, 3, 5, 7 })
            solve(i, n);
        stdin.close();
    }
}
