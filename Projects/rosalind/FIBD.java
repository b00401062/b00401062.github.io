package rosalind;

import java.io.*;
import java.util.*;

public class FIBD {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt(), m = stdin.nextInt();
        long mature = 0;
        long[] generation = new long[n+m-1];
        generation[m-1] = 1;
        for (int i = m; i < n+m-1; i++) {
            generation[i] = mature;
            mature = mature - generation[i-m] + generation[i-1];
        }
        System.out.println(mature + generation[n+m-2]);
        stdin.close();
    }
}
