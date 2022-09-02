package leetcode;

import java.util.Arrays;

class LeetCode {
    public static boolean canPartition(int[] nums) {
        final int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        final int target = sum / 2;
        final boolean[] cache = new boolean[target + 1];
        cache[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            final int num = nums[i - 1];
            for (int j = target; j >= num; j--) {
                cache[j] = cache[j] || cache[j - num];
            }
        }
        return cache[target];
    }
}
