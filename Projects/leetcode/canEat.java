package leetcode;

class LeetCode {
    private static boolean canEat(long[] cumulativeCounts, int[] query) {
        int favoriteType = query[0];
        long favoriteDay = query[1];
        long dailyCap = query[2];
        long minCandyCap = favoriteDay;
        long maxCandyCap = (favoriteDay + 1) * dailyCap;
        long minCount = favoriteType == 0 ? 0 : cumulativeCounts[favoriteType - 1];
        long maxCount = cumulativeCounts[favoriteType];
        return maxCount > minCandyCap && maxCandyCap > minCount;
    }

    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        final long[] cumulativeCounts = new long[candiesCount.length];
        cumulativeCounts[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            cumulativeCounts[i] = cumulativeCounts[i - 1] + candiesCount[i];
        }
        boolean[] canEats = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            canEats[i] = canEat(cumulativeCounts, query);
        }
        return canEats;
    }
}
