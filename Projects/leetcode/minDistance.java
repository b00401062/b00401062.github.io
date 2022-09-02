package leetcode;

class LeetCode {
    private class Cache {
        int diag;
        int dist;
        
        public void update(int diag, int dist) {
            this.diag = diag;
            this.dist = dist;
        }
    }

    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int j = 0; j <= word2.length(); j++) {
            dp[j] = j;
        }
        Cache cache = new Cache();
        for (int i = 0; i < word1.length(); i++) {
            final char c1 = word1.charAt(i);
            cache.update(dp[0], i + 1);
            dp[0] = cache.dist;
            for (int j = 0; j < word2.length(); j++) {
                final char c2 = word2.charAt(j);
                cache.update(
                    dp[j + 1],
                    Math.min(
                        cache.diag + (c1 == c2 ? 0 : 1),
                        Math.min(dp[j], dp[j + 1]) + 1
                    )
                );
                dp[j + 1] = cache.dist;
            }
        }
        return dp[word2.length()];
    }
}
