package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class REPLESX {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int x = stdin.nextInt();
            int p = stdin.nextInt();
            int k = stdin.nextInt();
            int st_cnt = 0;
            int eq_cnt = 0;
            while (n-- > 0) {
                int a = stdin.nextInt();
                if (a < x) st_cnt++;
                else if (a == x) eq_cnt++;
            }
            if (p <= st_cnt && k <= p) {
                System.out.println(st_cnt - p + 1);
            } else if (st_cnt < p && p <= st_cnt + eq_cnt) {
                System.out.println(0);
            } else if (st_cnt + eq_cnt < p && p <= k) {
                System.out.println(p - st_cnt - eq_cnt);
            } else {
                System.out.println(-1);
            }
        }
        stdin.close();
    }
}
