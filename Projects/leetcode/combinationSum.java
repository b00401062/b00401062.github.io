package leetcode

private fun recur(candidates: IntArray, target: Int): List<List<Int>> {
    if (target == 0)
        return listOf(emptyList())
    else if (candidates.isEmpty())
        return emptyList()
    val res = mutableListOf<List<Int>>()
    for ((i, candidate) in candidates.withIndex()) {
        if (target < candidate)
            break
        else if (target == candidate) {
            res.add(listOf(candidate))
            break
        } else for (n in 1..target / candidate) {
            recur(
                candidates.sliceArray(i + 1 until candidates.size),
                target - candidate * n
            ).forEach { res.add(List(n) { candidate } + it) }
        }
    }
    return res
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    return recur(candidates, target)
}
