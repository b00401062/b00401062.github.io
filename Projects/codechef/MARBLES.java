package codechef;

import java.util.*;
import java.io.*;
import java.math.*;

public class MARBLES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = 0, k = 0;
            if (sc.hasNextInt()) {
                n = sc.nextInt();
            }
            if (sc.hasNextInt()) {
                k = sc.nextInt();
            }
            if (n == k) {
                System.out.println(1);
            } else {
                n = n - k;
                long ans = 1;
                for (int i = 1; i < k; i++) {
                    ans = ans * (n + i) / i;
                }
                System.out.println(ans);
            }
        }
    }
}
