package usaco;

import java.io.*;
import java.util.*;

public class pprime {
    private static int a;
    private static int b;
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
    private static void generatePPrime(String current, int digits) {
        if (current.equals("0"))
            return;
        if (current.length() == (digits + 1) / 2) {
            for (int i = digits / 2 - 1; i >= 0; i--)
                current += current.charAt(i);
            int currentInt = Integer.parseInt(current);
            if (isPrime(currentInt) && currentInt >= a && currentInt <= b)
                stdout.println(current);
            return;
        }
        for (int nextDigit = 0; nextDigit < 10; nextDigit++)
            if (!current.equals("") || nextDigit % 2 == 1)
                generatePPrime(current + nextDigit, digits);
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("pprime.in"));
        stdout = new PrintWriter(new File("pprime.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        a = stdin.nextInt();
        b = stdin.nextInt();
        for (int digits = String.valueOf(a).length(); digits <= String.valueOf(b).length(); digits++)
            generatePPrime("", digits);
        stdin.close();
    }
}
