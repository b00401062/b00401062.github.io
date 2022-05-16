package rosalind;

import java.io.*;
import java.util.*;

public class PROB {
    private static final Integer A = (int) 'A', C = (int) 'C', G = (int) 'G', T = (int) 'T';
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        final String seq = stdin.next();
        final int a = (int) seq.chars().filter(A::equals).count();
        final int c = (int) seq.chars().filter(C::equals).count();
        final int g = (int) seq.chars().filter(G::equals).count();
        final int t = (int) seq.chars().filter(T::equals).count();
        while (stdin.hasNext()) {
            final double p = stdin.nextDouble();
            System.out.println(Math.log10(p/2) * (c+g) + Math.log10((1-p)/2) * (a+t));
        }
        stdin.close();
    }
}
