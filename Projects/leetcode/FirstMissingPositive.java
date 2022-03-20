package leetcode;

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        for (int num : nums) {
            int pos = Math.abs(num) - 1;
            if (pos >= n) continue;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
