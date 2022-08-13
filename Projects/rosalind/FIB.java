package rosalind;

import java.io.*;
import java.util.*;

public class FIB {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt(), k = stdin.nextInt();
        long mature = 0;
        long[] generation = new long[n];
        generation[0] = 1;
        for (int i = 1; i < n; i++) {
            generation[i] = mature * k;
            mature += generation[i-1];
        }
        System.out.println(mature + generation[n-1]);
        stdin.close();
    }
}
