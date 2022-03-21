package leetcode

fun isScramble(s1: String, s2: String): Boolean {
    val N = s1.length
    if (N == 0) return false
    if (s1 == s2) return true
    val counts: MutableMap<Char, Int> = HashMap()
    for (i in 0 until N) {
        val c1 = s1[i]
        val c2 = s2[i]
        val count1 = counts.getOrDefault(c1, 0) + 1
        if (count1 == 0) counts.remove(c1) else counts[c1] = count1
        val count2 = counts.getOrDefault(c2, 0) - 1
        if (count2 == 0) counts.remove(c2) else counts[c2] = count2
        if (counts.isEmpty() &&
            isScramble(s1.substring(i + 1), s2.substring(i + 1)) &&
            isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
        ) return true
    }
    if (counts.isNotEmpty()) return false
    for (i in 0 until N) {
        val c1 = s1[i]
        val c2 = s2[N - i - 1]
        val count1 = counts.getOrDefault(c1, 0) + 1
        if (count1 == 0) counts.remove(c1) else counts[c1] = count1
        val count2 = counts.getOrDefault(c2, 0) - 1
        if (count2 == 0) counts.remove(c2) else counts[c2] = count2
        if (counts.isEmpty() &&
            isScramble(s1.substring(i + 1), s2.substring(0, N - i - 1)) &&
            isScramble(s1.substring(0, i + 1), s2.substring(N - i - 1))
        ) return true
    }
    return false
}
