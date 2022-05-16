package leetcode

import java.util.stream.IntStream

fun waysToMakeFair(nums: IntArray): Int {
    var evenSum = IntStream.range(0, nums.size).filter { i: Int -> i % 2 == 0 }.map { i: Int -> nums[i] }.sum()
    var oddSum = IntStream.range(0, nums.size).filter { i: Int -> i % 2 == 1 }.map { i: Int -> nums[i] }.sum()
    var count = 0
    for (i in nums.indices.reversed()) {
        val num = nums[i]
        if (i % 2 == 0) evenSum -= num else oddSum -= num
        if (evenSum == oddSum) count++
        if (i % 2 == 0) oddSum += num else evenSum += num
    }
    return count
}
