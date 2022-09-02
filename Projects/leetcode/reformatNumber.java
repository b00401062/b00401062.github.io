package leetcode;

class LeetCode {
    public static String reformatNumber(String number) {
        char[] chars = number.replaceAll("-", "").replaceAll(" ", "").toCharArray();
        final int n = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            sb.append(chars, i, Math.min(3, n - i));
            sb.append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        if (n % 3 == 1) {
            sb.delete(sb.length() - 5, sb.length());
            sb.append(chars, n - 4, 2);
            sb.append("-");
            sb.append(chars, n - 2, 2);
        }
        return sb.toString();
    }
}
