package leetcode

private const val MODULO: Long = 1000000007

fun countPairs(deliciousness: IntArray): Int {
    val counts: MutableMap<Int, Long> = HashMap()
    for (d in deliciousness) {
        counts[d] = counts.getOrDefault(d, 0L) + 1
    }
    var pairCount: Long = 0
    for (i in 0..21) {
        val targetSum = 1 shl i
        for (smallerKey in counts.keys) {
            val largerKey = targetSum - smallerKey
            pairCount += if (largerKey < smallerKey) continue else if (largerKey == smallerKey) {
                val keyCount = counts[smallerKey]!!
                keyCount * (keyCount - 1) / 2
            } else {
                val smallerKeyCount = counts[smallerKey]!!
                val largerKeyCount = counts.getOrDefault(largerKey, 0L)
                smallerKeyCount * largerKeyCount
            }
            pairCount %= MODULO
        }
    }
    return pairCount.toInt()
}
