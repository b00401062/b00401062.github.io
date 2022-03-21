package leetcode

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if (s1.length + s2.length != s3.length) return false
    val dp = BooleanArray(s2.length + 1)
    dp[0] = true
    for (j in 0 until s2.length) {
        if (s2[j] != s3[j]) break
        dp[j + 1] = true
    }
    for (i in 0 until s1.length) {
        dp[0] = dp[0] && s1[i] == s3[i]
        for (j in 0 until s2.length) {
            dp[j + 1] = dp[j] && s2[j] == s3[i + j + 1] ||
                    dp[j + 1] && s1[i] == s3[i + j + 1]
        }
    }
    return dp[s2.length]
}
