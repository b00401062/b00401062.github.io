package leetcode;

class LeetCode {
    public static int stoneGameVII(int[] stones) {
        final int n = stones.length;
        int[][] cache = new int[n + 1][n + 1];
        for (int len = 2 + n % 2; len <= n; len += 2) {
            for (int lt = 0, rt = lt + len; rt <= n; lt++, rt++) {
                cache[lt][rt] = Math.max(
                    Math.min(
                        stones[lt + 1] + cache[lt + 2][rt],
                        stones[rt - 1] + cache[lt + 1][rt - 1]
                    ),
                    Math.min(
                        stones[lt] + cache[lt + 1][rt - 1],
                        stones[rt - 2] + cache[lt][rt - 2]
                    )
                );
            }
        }
        return cache[0][n];
    }
}
