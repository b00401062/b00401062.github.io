package codechef;

import java.io.*;
import java.util.Scanner;

class CVDRUN {
    private static int gcd(int n, int k) {
        int max = Math.max(n, k);
        int min = Math.min(n, k);
        while (max % min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int k = stdin.nextInt();
            int x = stdin.nextInt();
            int y = stdin.nextInt();
            boolean isReachable = k == 0 ? x == y : Math.abs(x - y) % gcd(n, k) == 0;
            System.out.println(isReachable ? "YES" : "NO");
        }
        stdin.close();
        stdout.flush();
        stdout.close();
    }
}
