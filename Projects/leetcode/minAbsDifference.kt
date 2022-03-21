package leetcode

import leetcode.MinAbsDifference
import java.util.ArrayList
import java.util.Arrays
import java.util.Collections

object MinAbsDifference {
    private fun dfs(nums: IntArray, i: Int, sum: Int, subsetSums: MutableList<Int>) {
        if (i == nums.size) {
            subsetSums.add(sum)
            return
        }
        dfs(nums, i + 1, sum + nums[i], subsetSums)
        dfs(nums, i + 1, sum, subsetSums)
    }

    private fun sortedSubsetSums(nums: IntArray, beginIdx: Int, endIdx: Int): List<Int> {
        val subsetSums: MutableList<Int> = ArrayList()
        dfs(Arrays.copyOfRange(nums, beginIdx, endIdx), 0, 0, subsetSums)
        Collections.sort(subsetSums)
        return subsetSums
    }

    fun minAbsDifference(nums: IntArray, goal: Int): Int {
        var minAbsDifference = Int.MAX_VALUE
        val frontSubsetSums = sortedSubsetSums(nums, 0, nums.size / 2)
        val backSubsetSums = sortedSubsetSums(nums, nums.size / 2, nums.size)
        for (frontSubsetSum in frontSubsetSums) {
            val remainingSetsetSum = goal - frontSubsetSum
            val matchedIdx = Collections.binarySearch(backSubsetSums, remainingSetsetSum)
            if (matchedIdx >= 0) return 0
            val insertedAtIdx = -1 * (matchedIdx + 1)
            if (insertedAtIdx > 0) {
                minAbsDifference = Math.min(
                    minAbsDifference,
                    Math.abs(remainingSetsetSum - backSubsetSums[insertedAtIdx - 1])
                )
            }
            if (insertedAtIdx < backSubsetSums.size) {
                minAbsDifference = Math.min(
                    minAbsDifference,
                    Math.abs(remainingSetsetSum - backSubsetSums[insertedAtIdx])
                )
            }
        }
        return minAbsDifference
    }
}