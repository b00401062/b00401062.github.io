package leetcode

private fun canEat(cumulativeCounts: LongArray, query: IntArray): Boolean {
    val favoriteType = query[0]
    val favoriteDay = query[1].toLong()
    val dailyCap = query[2].toLong()
    val maxCandyCap = (favoriteDay + 1) * dailyCap
    val minCount = if (favoriteType == 0) 0 else cumulativeCounts[favoriteType - 1]
    val maxCount = cumulativeCounts[favoriteType]
    return maxCount > favoriteDay && maxCandyCap > minCount
}

fun canEat(candiesCount: IntArray, queries: Array<IntArray>): BooleanArray {
    val cumulativeCounts = LongArray(candiesCount.size)
    cumulativeCounts[0] = candiesCount[0].toLong()
    for (i in 1 until candiesCount.size) {
        cumulativeCounts[i] = cumulativeCounts[i - 1] + candiesCount[i]
    }
    val canEats = BooleanArray(queries.size)
    for (i in queries.indices) {
        val query = queries[i]
        canEats[i] = canEat(cumulativeCounts, query)
    }
    return canEats
}
