package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class SIGN {
    private static int factorial(int i) {
        return i == 0 ? 1 : i * factorial(i-1);
    }
    private static boolean next(int[] s) {
        final int n = s.length;
        int l = n-2, r = n-1;
        for (; l >= 0 && s[l] >= s[l+1]; l--);
        if (l < 0) return false;
        for (; r >= l && s[l] >= s[r]; r--);
        s[l] ^= s[r] ^ (s[r] = s[l]);
        for (int i = 1; i <= (n - l)/2; i++)
            s[l+i] ^= s[n-i] ^ (s[n-i] = s[l+i]);
        return true;
    }
    private static void abuse(int[] s, int l) {
        if (l == s.length) {
            System.out.println(Arrays.stream(s).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }
        abuse(s, l+1);
        s[l] = -s[l];
        abuse(s, l+1);
        s[l] = -s[l];
    }
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        PrintStream stdout = System.out;
        final int n = stdin.nextInt();
        stdout.println(factorial(n) * (int) Math.pow(2, n));
        int[] s = IntStream.rangeClosed(1, n).toArray();
        do {
            abuse(s, 0);
        } while (next(s));
        stdin.close();
    }
}
