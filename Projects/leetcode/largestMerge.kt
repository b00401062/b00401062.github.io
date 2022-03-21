package leetcode

fun largestMerge(word1: String, word2: String): String {
    val sb = StringBuilder()
    var i = 0
    var j = 0
    while (i < word1.length || j < word2.length) {
        if (i == word1.length) {
            sb.append(word2.substring(j))
            j = word2.length
        } else if (j == word2.length) {
            sb.append(word1.substring(i))
            i = word1.length
        } else if (word1[i] > word2[j]) {
            sb.append(word1[i])
            i++
        } else if (word1[i] < word2[j]) {
            sb.append(word2[j])
            j++
        } else {
            val diff = word1.substring(i).compareTo(word2.substring(j))
            if (diff >= 0) {
                sb.append(word1[i])
                i++
            } else {
                sb.append(word2[j])
                j++
            }
        }
    }
    return sb.toString()
}
