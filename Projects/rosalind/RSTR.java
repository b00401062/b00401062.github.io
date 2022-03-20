package rosalind;

import java.io.*;
import java.util.*;

public class RSTR {
    private static final Integer A = (int) 'A', C = (int) 'C', G = (int) 'G', T = (int) 'T';
    public static void main (String[] args) throws IOException {
        final Scanner stdin = new Scanner(System.in);
        final int n = stdin.nextInt();
        final double p = stdin.nextDouble();
        final String read = stdin.next();
        final int a = (int) read.chars().filter(A::equals).count();
        final int c = (int) read.chars().filter(C::equals).count();
        final int g = (int) read.chars().filter(G::equals).count();
        final int t = (int) read.chars().filter(T::equals).count();
        System.out.println(1 - Math.pow(1 - Math.pow(p/2, c+g) * Math.pow((1-p)/2, a+t), n));
        stdin.close();
    }
}
