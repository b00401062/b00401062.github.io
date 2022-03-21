package codechef;

import java.util.Scanner;

class CHPINTU {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int m = stdin.nextInt();
            int[] fs = new int[n];
            boolean[] isAvailables = new boolean[m];
            for (int i = 0; i < n; i++) {
                int f = stdin.nextInt();
                fs[i] = f;
                isAvailables[f - 1] = true;
            }
            int[] costs = new int[m];
            for (int i = 0; i < n; i++) {
                costs[fs[i] - 1] += stdin.nextInt();
            }
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if (!isAvailables[i]) continue;
                minCost = Math.min(minCost, costs[i]);
            }
            System.out.println(minCost);
        }
        stdin.close();
    }
}
