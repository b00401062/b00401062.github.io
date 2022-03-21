package leetcode

import java.util.*

fun maxResult(nums: IntArray, k: Int): Int {
    val n = nums.size
    val cache = PriorityQueue(Comparator.comparingInt { obj: Pair -> obj.maxResult() }
        .reversed())
    cache.add(Pair(nums[0], 0))
    for (i in 1 until n) {
        val num = nums[i]
        while (i > cache.peek().idx + k) {
            cache.remove()
        }
        val maxResult = cache.peek().maxResult + num
        cache.add(Pair(maxResult, i))
    }
    while (cache.peek().idx != n - 1) {
        cache.remove()
    }
    return cache.peek().maxResult
}

private class Pair(val maxResult: Int, val idx: Int) {
    fun maxResult(): Int {
        return maxResult
    }
}
