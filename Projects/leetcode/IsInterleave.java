package leetcode;

class IsInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) != s3.charAt(j)) break;
            dp[j + 1] = true;
        }
        for (int i = 0; i < s1.length(); i++) {
            dp[0] = dp[0] && s1.charAt(i) == s3.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                dp[j + 1] = (
                    dp[j] && s2.charAt(j) == s3.charAt(i + j + 1) ||
                    dp[j + 1] && s1.charAt(i) == s3.charAt(i + j + 1)
                );
            }
        }
        return dp[s2.length()];
    }
}
