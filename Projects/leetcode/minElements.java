package leetcode;

class LeetCode {
    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long deficit = goal - sum;
        return (int) Math.abs(deficit / limit) + (deficit % limit == 0 ? 0 : 1);
    }
}
