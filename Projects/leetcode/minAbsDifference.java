package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LeetCode {
    private static void dfs(int[] nums, int i, int sum, List<Integer> subsetSums) {
        if (i == nums.length) {
            subsetSums.add(sum);
            return;
        }
        dfs(nums, i + 1, sum + nums[i], subsetSums);
        dfs(nums, i + 1, sum, subsetSums);
    }

    private static List<Integer> sortedSubsetSums(int[] nums, int beginIdx, int endIdx) {
        List<Integer> subsetSums = new ArrayList<>();
        dfs(Arrays.copyOfRange(nums, beginIdx, endIdx), 0, 0, subsetSums);
        Collections.sort(subsetSums);
        return subsetSums;
    }

    public static int minAbsDifference(int[] nums, int goal) {
        int minAbsDifference = Integer.MAX_VALUE;
        List<Integer> frontSubsetSums = sortedSubsetSums(nums, 0, nums.length / 2);
        List<Integer> backSubsetSums = sortedSubsetSums(nums, nums.length / 2, nums.length);
        for (int frontSubsetSum : frontSubsetSums) {
            int remainingSetsetSum = goal - frontSubsetSum;
            int matchedIdx = Collections.binarySearch(backSubsetSums, remainingSetsetSum);
            if (matchedIdx >= 0) return 0;
            int insertedAtIdx = -1 * (matchedIdx + 1);
            if (insertedAtIdx > 0) {
                minAbsDifference = Math.min(
                    minAbsDifference,
                    Math.abs(remainingSetsetSum - backSubsetSums.get(insertedAtIdx - 1))
                );
            }
            if (insertedAtIdx < backSubsetSums.size()) {
                minAbsDifference = Math.min(
                    minAbsDifference,
                    Math.abs(remainingSetsetSum - backSubsetSums.get(insertedAtIdx))
                );
            }
        }
        return minAbsDifference;
    }
}
