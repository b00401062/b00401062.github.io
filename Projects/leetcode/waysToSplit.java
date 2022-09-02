package leetcode;

class LeetCode {
    private static final int MODULO = 1000000007;

    public static int waysToSplit(int[] nums) {
        final int n = nums.length;
        int count = 0;
        for (int i = 1; i < n; ++i)
            nums[i] += nums[i - 1];
        for (int i = 0, minJ = 1, maxJ = 1; i < n - 2; ++i) {
            minJ = Math.max(minJ, i + 1);
            while (minJ < n - 1 && nums[minJ] < nums[i] * 2)
                ++minJ;
            maxJ = Math.max(maxJ, minJ);
            while (maxJ < n - 1 && nums[maxJ] - nums[i] <= nums[n - 1] - nums[maxJ])
                ++maxJ;
            count = (count + maxJ - minJ) % MODULO;
        }
        return count;
    }
}
