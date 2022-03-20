package leetcode;

import java.util.ArrayList;
import java.util.List;

class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            final int num = Math.abs(nums[i]) - 1;
            if (nums[num] < 0) duplicates.add(num + 1);
            else nums[num] *= -1;
        }
        return duplicates;
    }
}
