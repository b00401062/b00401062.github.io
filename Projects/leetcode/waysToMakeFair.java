package leetcode;

import java.util.stream.IntStream;

class LeetCode {
    public static int waysToMakeFair(int[] nums) {
        int evenSum = IntStream.range(0, nums.length).filter(i -> i % 2 == 0).map(i -> nums[i]).sum();
        int oddSum = IntStream.range(0, nums.length).filter(i -> i % 2 == 1).map(i -> nums[i]).sum();
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            final int num = nums[i];
            if (i % 2 == 0) evenSum -= num;
            else oddSum -= num;
            if (evenSum == oddSum) count++;
            if (i % 2 == 0) oddSum += num;
            else evenSum += num;
        }
        return count;
    }
}
