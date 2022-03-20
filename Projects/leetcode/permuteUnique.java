package leetcode

fun permuteUnique(nums: IntArray): List<List<Int>> {
    fun factorial(n: Int): Int =
        (1..n).reduce { x1: Int, x2: Int -> x1 * x2 }
    if (nums.isEmpty())
        return listOf()
    val list = mutableListOf<List<Int>>()
    list.add(nums.copyOf().asList())
    repeat(factorial(nums.size) - 1) {
        nextPermutation(nums)
        val candidate = nums.copyOf().asList()
        if (list[0] == candidate) return list
        list.add(candidate)
    }
    return list
}
