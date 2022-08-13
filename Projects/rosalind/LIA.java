package rosalind;

import java.io.*;
import java.util.*;

public class LIA {
    private static final double[][] T = new double[][] {
        { 4./16, 2./16, 0./16, 2./16, 1./16, 0./16, 0./16, 0./16, 0./16 }, // AA BB
        { 4./16, 4./16, 4./16, 2./16, 2./16, 2./16, 0./16, 0./16, 0./16 }, // AA Bb
        { 0./16, 2./16, 4./16, 0./16, 1./16, 2./16, 0./16, 0./16, 0./16 }, // AA bb
        { 4./16, 2./16, 0./16, 4./16, 2./16, 0./16, 4./16, 2./16, 0./16 }, // Aa BB
        { 4./16, 4./16, 4./16, 4./16, 4./16, 4./16, 4./16, 4./16, 4./16 }, // Aa Bb
        { 0./16, 2./16, 4./16, 0./16, 2./16, 4./16, 0./16, 2./16, 4./16 }, // Aa bb
        { 0./16, 0./16, 0./16, 2./16, 1./16, 0./16, 4./16, 2./16, 0./16 }, // aa BB
        { 0./16, 0./16, 0./16, 2./16, 2./16, 2./16, 4./16, 4./16, 4./16 }, // aa Bb
        { 0./16, 0./16, 0./16, 0./16, 1./16, 2./16, 0./16, 2./16, 4./16 }, // aa bb
    };
    private static double choose(int N, int r) {
        double x = 1;
        for (int i = N; i > N-r; i--)
            x *= i;
        for (int i = r; i > 0; i--)
            x /= i;
        return x;
    }
    private static double[] multiply(double[][] A, double[] x) {
        double[] b = new double[x.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                b[i] += A[i][j] * x[j];
        return b;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        final int k = stdin.nextInt(), n = stdin.nextInt();
        double[] x = new double[] { 0, 0, 0, 0, 1, 0, 0, 0, 0 };
        for (int i = 0; i < k; i++)
            x = multiply(T, x);
        final int N = (int) Math.pow(2, k);
        double P = 0, p = x[4];
        for (int i = n; i <= N; i++)
            P += choose(N, i) * Math.pow(p, i) * Math.pow(1-p, N-i);
        System.out.println(P);
        stdin.close();
    }
}
