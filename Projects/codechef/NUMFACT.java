package codechef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class NUMFACT {
    private static int[] getPrimesBelow(int n) {
        boolean[] marked = new boolean[n];
        marked[0] = true;
        marked[1] = true;
        for (int i = 2; i < n; i++) {
            for (int p = i << 1; p < n; p += i) {
                marked[p] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                primes.add(i);
            }
        }
        return primes.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        int[] primes = getPrimesBelow(1000000);
        while (T-- > 0) {
            int N = stdin.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = stdin.nextInt();
            }
            int[] counts = new int[primes.length];
            Arrays.fill(counts, 1);
            for (int a : A) {
                for (int i = 0; i < primes.length; i++) {
                    int prime = primes[i];
                    if (a < prime) break;
                    while (a % prime == 0) {
                        counts[i]++;
                        a /= prime;
                    }
                }
            }
            int count = Arrays.stream(counts).reduce((x1, x2) -> x1 * x2).getAsInt();
            System.out.println(count);
        }
        stdin.close();
    }
}
