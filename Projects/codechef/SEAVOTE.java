package codechef;

import java.util.Arrays;
import java.util.Scanner;

class SEAVOTE {
    private static boolean solve(int[] bs) {
        int nPositives = (int) Arrays.stream(bs).filter(x -> x > 0).count();
        int sum = Arrays.stream(bs).reduce((x1, x2) -> x1 + x2).getAsInt();
        return 100 > sum - nPositives && 100 <= sum;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int[] bs = new int[n];
            for (int i = 0; i < n; i++) {
                bs[i] = stdin.nextInt();
            }
            boolean res = solve(bs);
            System.out.println(res ? "YES" : "NO");
        }
        stdin.close();
    }
}
