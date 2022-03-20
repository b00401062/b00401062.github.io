package leetcode;

import java.util.HashSet;
import java.util.Set;

class MaximumUniqueSubarray {
    public static int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0;
        int curScore = 0;
        int head = 0;
        Set<Integer> set = new HashSet<>();
        for (int tail = 0; tail < nums.length; tail++) {
            final int num = nums[tail];
            if (set.contains(num)) {
                maxScore = Math.max(maxScore, curScore);
                while (nums[head] != num) {
                    int removedNum = nums[head++];
                    set.remove(removedNum);
                    curScore -= removedNum;
                }
                head++;
            } else {
                set.add(num);
                curScore += num;
            }
        }
        maxScore = Math.max(maxScore, curScore);
        return maxScore;
    }
}
