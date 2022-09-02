package leetcode;

class LeetCode {
    public static int minMoves(int[] nums, int limit) {
        final int n = nums.length;
        final int[] changes = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            final int ltNum = nums[i];
            final int rtNum = nums[n - i - 1];
            final int maxNum = Math.max(ltNum, rtNum);
            final int minNum = Math.min(ltNum, rtNum);
            changes[minNum + 1] -= 1;
            changes[ltNum + rtNum] -= 1;
            changes[ltNum + rtNum + 1] += 1;
            changes[maxNum + limit + 1] += 1;
        }
        int minMoves = n;
        int numMoves = n;
        for (int i = 2; i <= 2 * limit; i++) {
            numMoves += changes[i];
            minMoves = Math.min(minMoves, numMoves);
        }
        return minMoves;
    }
}
