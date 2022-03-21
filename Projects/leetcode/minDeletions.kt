package leetcode

fun minDeletions(s: String): Int {
    val table: MutableMap<Char, Int> = HashMap()
    for (c in s.toCharArray()) {
        table[c] = table.getOrDefault(c, 0) + 1
    }
    val frequencies = table.values.stream()
        .sorted(Comparator.reverseOrder())
        .mapToInt { obj: Int -> obj }.toArray()
    var minDeletion = 0
    for (i in 1 until frequencies.size) {
        val delta = frequencies[i] - Math.max(0, frequencies[i - 1] - 1)
        if (delta <= 0) continue
        frequencies[i] -= delta
        minDeletion += delta
    }
    return minDeletion
}
