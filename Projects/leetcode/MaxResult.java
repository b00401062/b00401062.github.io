package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class MaxResult {
    private static class Pair {
        private int maxResult;
        private int idx;

        Pair(int maxResult, int idx) {
            this.maxResult = maxResult;
            this.idx = idx;
        }

        public int maxResult() {
            return maxResult;
        }
    }

    public static int maxResult(int[] nums, int k) {
        final int n = nums.length;
        final PriorityQueue<Pair> cache = new PriorityQueue<>(Comparator.comparingInt(Pair::maxResult).reversed());
        cache.add(new Pair(nums[0], 0));
        for (int i = 1; i < n; i++) {
            final int num = nums[i];
            while (i > cache.peek().idx + k) {
                cache.remove();
            }
            final int maxResult = cache.peek().maxResult + num;
            cache.add(new Pair(maxResult, i));
        }
        while (cache.peek().idx != n - 1) {
            cache.remove();
        }
        return cache.peek().maxResult;
    }
}
