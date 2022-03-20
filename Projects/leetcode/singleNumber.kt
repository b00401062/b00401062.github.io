package leetcode

fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (num in nums) {
        res = res xor num
    }
    return res
}
