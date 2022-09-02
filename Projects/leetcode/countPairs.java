package leetcode;

import java.util.HashMap;
import java.util.Map;

class LeetCode {
    private static final long MODULO = 1000000007;

    public static int countPairs(int[] deliciousness) {
        Map<Integer, Long> counts = new HashMap<>();
        for (int d : deliciousness) {
            counts.put(d, counts.getOrDefault(d, 0L) + 1);
        }
        long pairCount = 0;
        for (int i = 0; i <= 21; i++) {
            int targetSum = 1 << i;
            for (int smallerKey : counts.keySet()) {
                int largerKey = targetSum - smallerKey;
                if (largerKey < smallerKey) continue;
                else if (largerKey == smallerKey) {
                    long keyCount = counts.get(smallerKey);
                    pairCount += keyCount * (keyCount - 1) / 2;
                } else {
                    long smallerKeyCount = counts.get(smallerKey);
                    long largerKeyCount = counts.getOrDefault(largerKey, 0L);
                    pairCount += smallerKeyCount * largerKeyCount;
                }
                pairCount %= MODULO;
            }
        }
        return (int) pairCount;
    }
}
