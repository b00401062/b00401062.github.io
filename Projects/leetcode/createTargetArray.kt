package leetcode

import java.util.ArrayList
import java.util.function.ToIntFunction

internal class CreateTargetArray {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val res: List<Int> = ArrayList()
        for (i in nums.indices) {
            res.add(index[i], nums[i])
        }
        return res.stream().mapToInt { obj: Int -> obj }.toArray()
    }
}