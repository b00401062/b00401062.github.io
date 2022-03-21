package codechef;

import java.io.*;
import java.util.Scanner;

class ENGXOR {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int q = stdin.nextInt();
            int lastA = 0;
            int nOdds = 0;
            for (int i = 0; i < n; i++) {
                lastA = stdin.nextInt();
                int cardinality = Integer.bitCount(lastA);
                nOdds += cardinality % 2;
            }
            int lastACardinality = Integer.bitCount(lastA);
            while (q-- > 0) {
                int p = stdin.nextInt();
                int cardinality = Integer.bitCount(p ^ lastA);
                boolean isSame = (cardinality % 2) == (lastACardinality % 2);
                int resNOdds = isSame ? nOdds : n - nOdds;
                stdout.write(String.format("%d %d\n", n - resNOdds, resNOdds));
            }
        }
        stdin.close();
        stdout.flush();
        stdout.close();
    }
}
