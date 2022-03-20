package leetcode

import kotlin.math.min

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var prefix = strs[0]
    for (s in strs.sliceArray(1 until strs.size)) {
        prefix = prefix.substring(0 until min(prefix.length, s.length))
        for (i in prefix.indices)
            if (prefix[i] != s[i]) {
                prefix = prefix.substring(0, i)
                break
            }
        if (prefix.isEmpty()) return prefix
    }
    return prefix
}
