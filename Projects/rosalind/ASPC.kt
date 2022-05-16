package rosalind;

import java.io.*;
import java.util.*;
import java.math.*;

public class ASPC {
    private static BigInteger choose(int n, int k) {
        BigInteger c = BigInteger.ONE;
        for (int i = n; i > n-k; i--)
            c = c.multiply(new BigInteger(String.valueOf(i)));
        for (int i = k; i > 0; i--)
            c = c.divide(new BigInteger(String.valueOf(i)));
        return c;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        final int n = stdin.nextInt(), k = stdin.nextInt();
        BigInteger sum = BigInteger.ZERO;
        for (int i = k; i <= n; i++)
            sum = sum.add(choose(n, i));
        System.out.println(sum.mod(new BigInteger("1000000")));
        stdin.close();
    }
}
