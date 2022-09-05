package leetcode

class LeetCode {
    private static String padAndReverse(String s, int len) {
        var paddedS = "0".repeat(len - s.length()) + s;
        var reversedPaddedS = new StringBuilder(paddedS).reverse().toString();
        return reversedPaddedS;
    }

    public static String addBinary(String a, String b) {
        var res = new StringBuilder();
        var carry = 0;
        var maxLen = Math.max(a.length(), b.length());
        var reversedPaddedA = padAndReverse(a, maxLen);
        var reversedPaddedB = padAndReverse(b, maxLen);
        for (int i = 0; i < maxLen; i++) {
            var da = reversedPaddedA.charAt(i) - '0';
            var db = reversedPaddedB.charAt(i) - '0';
            var sum = da + db + carry;
            carry = sum / 2;
            res.append(String.valueOf(sum % 2));
        }
        if (carry == 1) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}
