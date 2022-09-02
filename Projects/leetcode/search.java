package leetcode;

class LeetCode {
    private static boolean bruteForceSearch(int[] nums, int lt, int rt, int target) {
        for (int i = lt; i < rt; i++) {
            if (nums[i] == target) return true;
        }
        return false;
    }

    private static boolean recursiveSearch(int[] nums, int lt, int rt, int target) {
        int m = (lt + rt) / 2;
        return (
            rt - lt < 2 ? bruteForceSearch(nums, lt, rt, target) :
            nums[m] == target ? true :
            nums[lt] == nums[m] && nums[m] == nums[rt - 1] ? bruteForceSearch(nums, lt, rt, target) :
            (nums[lt] <= target) ^ (target < nums[m]) ^ (nums[lt] <= nums[m]) ? recursiveSearch(nums, lt, m, target) :
            recursiveSearch(nums, m + 1, rt, target)
        );
    }

    public static boolean search(int[] nums, int target) {
        return recursiveSearch(nums, 0, nums.length, target);
    }
}
