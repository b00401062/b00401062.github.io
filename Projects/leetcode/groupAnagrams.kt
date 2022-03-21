package leetcode

private fun str2code(str: String): Int {
    val counter = IntArray(26) { 0 }
    str.forEach { counter[it - 'a'] += 1 }
    return counter.contentHashCode()
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val dict = mutableMapOf<Int, MutableList<String>>()
    for (str in strs) {
        val list = dict.getOrPut(str2code(str)) { mutableListOf() }
        list.add(str)
    }
    return dict.values.toList()
}
