package leetcode;

class LeetCode {
    public static boolean check(int[] nums) {
        boolean isFlipped = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) continue;
            else if (isFlipped) return false;
            else isFlipped = true;
        }
        return !isFlipped || isFlipped && nums[0] >= nums[nums.length - 1];
    }
}
