package leetcode

internal class NumDistinct {
    fun numDistinct(s: String, t: String): Int {
        val table = IntArray(t.length + 1)
        table[0] = 1
        for (s_i in s.toCharArray()) {
            for (j in t.length - 1 downTo 0) {
                val t_j = t[j]
                if (s_i == t_j) table[j + 1] += table[j]
            }
        }
        return table[t.length]
    }
}