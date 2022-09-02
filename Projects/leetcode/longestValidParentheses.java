package leetcode

import kotlin.math.max

fun longestValidParentheses(s: String): Int {
    val sb = StringBuilder(s)
    do {
        var changed = false
        var lt_idx = -1
        for ((i, c) in sb.withIndex()) {
            if (c == '(') {
                lt_idx = i
            } else if (c == ')' && lt_idx != -1) {
                sb[lt_idx] = '*'
                sb[i] = '*'
                lt_idx = -1
                changed = true
            }
        }
    } while (changed)
    var res = 0
    var cnt = 0
    for (c in sb) {
        if (c != '*') {
            res = max(res, cnt)
            cnt = 0
        } else
            cnt++
    }
    res = max(res, cnt)
    return res
}
