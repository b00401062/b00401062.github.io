package leetcode;

class LeetCode {
    boolean isPalindrome(int x) {
        String xStr = Integer.toString(x);
        int xStrLen = xStr.length();
        for (int i = 0; i < xStrLen / 2; i++) {
            if (xStr.charAt(i) != xStr.charAt(xStrLen - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
