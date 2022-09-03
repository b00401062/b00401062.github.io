package codechef;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class HXOR {
    private static int find(int[] a, int i, int p) {
        final int n = a.length;
        for (int j = i + 1; j < n; j++) {
            if ((a[j] & (1 << p)) != 0) return j;
        }
        return n - 1;
    }

    private static void solve(int[] a, int x) {
        final int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            while (a[i] != 0 && x-- > 0) {
                int p = (int) (Math.log(a[i]) / Math.log(2));
                int j = find(a, i, p);
                a[i] ^= (1 << p);
                a[j] ^= (1 << p);
            }
        }
        if ((n == 2 && x % 2 == 1) || x == 1) {
            a[n - 2] ^= 1;
            a[n - 1] ^= 1;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            int x = stdin.nextInt();
            stdin.nextLine();
            int[] a = Arrays.stream(
                    stdin.nextLine().split(" ")
            ).mapToInt(Integer::valueOf).toArray();
            solve(a, x);
            System.out.println(
                    Arrays.stream(a)
                            .mapToObj(Integer::toString)
                            .collect(Collectors.joining(" "))
            );
        }
        stdin.close();
    }
}
