package leetcode;

import java.util.Arrays;

class LeetCode {
    private int[] cache = new int[] {
        1,
        1,
        2,
        5,
        14,
        42,
        132,
        429,
        1430,
        4862,
        16796,
        58786,
        208012,
        742900,
        2674440,
        9694845,
        35357670
    };

    private int numCacheTrees(int n) {
        assert cache.length > n;
        if (cache[n] != 0) {
            return cache[n];
        }
        int sol = 0;
        for (int i = 1; i <= n; i++) {
            sol += numCacheTrees(i - 1) * numCacheTrees(n - i);
        }
        return sol;
    }

    public int numTrees(int n) {
        if (n >= cache.length) {
            cache = Arrays.copyOf(cache, n + 1);
        }
        cache[0] = 1;
        return numCacheTrees(n);
    }
}
