package leetcode;

import java.util.ArrayList;
import java.util.List;

class LeetCode {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int num : nums) {
            final int i = Math.abs(num) - 1;
            if (nums[i] > 0) nums[i] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) continue;
            disappearedNumbers.add(i + 1);
        }
        return disappearedNumbers;
    }
}
