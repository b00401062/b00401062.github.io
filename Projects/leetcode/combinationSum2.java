package leetcode

import kotlin.math.min

private var table = mapOf<Int, Int>()

private fun recur(candidates: IntArray, target: Int): List<List<Int>> {
    if (target == 0)
        return listOf(emptyList())
    else if (candidates.isEmpty())
        return emptyList()
    val res = mutableListOf<List<Int>>()
    for ((i, candidate) in candidates.distinct().withIndex()) {
        if (target < candidate)
            break
        else if (target == candidate) {
            res.add(listOf(candidate))
            break
        } else for (n in 1..min(target / candidate, table[candidate]!!)) {
            recur(
                candidates.sliceArray(i + 1 until candidates.size),
                target - candidate * n
            ).forEach { res.add(List(n) { candidate } + it) }
        }
    }
    return res
}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    table = candidates.toList().groupingBy { it }.eachCount()
    return recur(table.keys.sorted().toIntArray(), target)
}
