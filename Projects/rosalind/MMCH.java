package rosalind;

import java.io.*;
import java.util.*;
import java.math.*;

public class MMCH {
    private static final Integer A = (int) 'A', C = (int) 'C', G = (int) 'G', U = (int) 'U';
    private static BigInteger permute(int N, int r) {
        BigInteger x = BigInteger.ONE;
        for (int i = N; i > N-r; i--)
            x = x.multiply(BigInteger.valueOf(i));
        return x;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        String read = "";
        while (stdin.hasNext())
            read += stdin.next();
        final int a = (int) read.chars().filter(A::equals).count();
        final int c = (int) read.chars().filter(C::equals).count();
        final int g = (int) read.chars().filter(G::equals).count();
        final int u = (int) read.chars().filter(U::equals).count();
        System.out.println(permute(Math.max(a, u), Math.min(a, u)).multiply(permute(Math.max(c, g), Math.min(c, g))));
        stdin.close();
    }
}
