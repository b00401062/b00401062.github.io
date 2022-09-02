package leetcode

fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (s.isEmpty() || words.isEmpty())
        return emptyList()
    val word_len = words.first().length
    val word_cnt = words.size
    val total_len = word_len * word_cnt
    if (total_len > s.length)
        return emptyList()
    val indices = mutableListOf<Int>()
    val hash_map = mutableMapOf<String, Int>()
    for (i in words.indices)
        hash_map[words[i]] = hash_map.getOrPut(words[i]) { 0 } + 1
    for (i in 0..s.length - total_len) {
        var j = i
        val temp_map = HashMap<String, Int>(hash_map)
        var temp_cnt = word_cnt
        while (j < i + total_len) {
            val word = s.substring(j, j + word_len)
            if (!hash_map.containsKey(word) || temp_map[word] == 0)
                break
            j += word_len
            temp_map[word] = temp_map[word]!! - 1
            temp_cnt--
        }
        if (temp_cnt == 0)
            indices.add(i)
    }
    return indices
}
