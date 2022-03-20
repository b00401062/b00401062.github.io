package leetcode;

class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            curSum = curSum >= 0 ? curSum + num : num;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
