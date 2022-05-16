package leetcode

fun combinationSum4(nums: IntArray, target: Int): Int {
    val cache = IntArray(target + 1)
    cache[0] = 1
    for (i in 1..target) {
        for (num in nums) {
            if (num > i) continue
            cache[i] += cache[i - num]
        }
    }
    return cache[target]
}
