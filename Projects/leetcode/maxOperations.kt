package leetcode

fun maxOperations(nums: IntArray, k: Int): Int {
    val table: MutableMap<Int, Int> = HashMap()
    for (num in nums) {
        table[num] = table.getOrDefault(num, 0) + 1
    }
    var opCount = 0
    for (num1 in table.keys) {
        val num2 = k - num1
        val numCount1 = table[num1]!!
        val numCount2 = table.getOrDefault(num2, 0)
        if (numCount1 == 0 || numCount2 == 0) continue
        if (num1 == num2) {
            opCount += numCount1 / 2
            table[num1] = numCount1 % 2
        } else {
            val deltaCount = Math.min(numCount1, numCount2)
            opCount += deltaCount
            table[num1] = numCount1 - deltaCount
            table[num2] = numCount2 - deltaCount
        }
    }
    return opCount
}
