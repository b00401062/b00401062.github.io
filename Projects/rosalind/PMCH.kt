package rosalind;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class PMCH {
    private static final Integer A = (int) 'A', G = (int) 'G';
    private static BigInteger factorial(long i) {
        return i == 0 ? BigInteger.ONE : factorial(i-1).multiply(BigInteger.valueOf(i));
    }
    public static void main(String args[]) throws IOException {
        Scanner stdin = new Scanner(System.in);
        stdin.next();
        String seq = "";
        while (stdin.hasNext())
            seq += stdin.next();
        System.out.println(factorial(seq.chars().filter(A::equals).count()).multiply(factorial(seq.chars().filter(G::equals).count())));
        stdin.close();
    }
}
