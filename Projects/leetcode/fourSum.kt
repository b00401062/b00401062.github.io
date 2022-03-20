package leetcode

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val list = mutableListOf<List<Int>>()
    nums.sort()
    for (i in 0 until nums.size - 3) {
        for (j in i + 1 until nums.size - 2) {
            var l = j + 1
            var r = nums.lastIndex
            while (l < r) {
                val sum = nums[i] + nums[j] + nums[l] + nums[r]
                if (sum < target)
                    l++
                else if (sum > target)
                    r--
                else {
                    val e = listOf(nums[i], nums[j], nums[l], nums[r])
                    if (!list.contains(e))
                        list.add(e)
                    l++
                    r--
                }
            }
        }
    }
    return list
}
