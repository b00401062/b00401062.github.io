package codechef;

import java.io.*;
import java.util.*;

class CHEFEZQ {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int k = stdin.nextInt();
            long debt = 0;
            for (int i = 1; i <= n; i++) {
                int q = stdin.nextInt();
                debt += q - k;
                if (debt < 0) {
                    stdin.nextLine();
                    System.out.println(i);
                    break;
                }
            }
            if (debt < 0) continue;
            System.out.println(n + debt / k + 1);
        }
        stdin.close();
    }
}
