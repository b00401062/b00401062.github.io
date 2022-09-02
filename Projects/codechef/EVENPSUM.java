package codechef;

import java.io.*;
import java.util.Scanner;

class EVENPSUM {
    private static long evenpsum(int a, int b) {
        long evenCountInA = a / 2;
        long oddCountInA = (a + 1) / 2;
        long evenCountInB = b / 2;
        long oddCountInB = (b + 1) / 2;
        return oddCountInA * oddCountInB + evenCountInA * evenCountInB;
    }

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = stdin.nextInt();
        while (t-- > 0) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            long pairCount = evenpsum(a, b);
            stdout.write(String.format("%d\n", pairCount));
        }
        stdin.close();
        stdout.flush();
        stdout.close();
    }
}
