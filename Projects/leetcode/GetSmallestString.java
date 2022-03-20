package leetcode;

class GetSmallestString {
    public static String getSmallestString(int n, int k) {
        final StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int c = Math.min(26, k - i);
            k -= c;
            sb.append((char) ('a' + c - 1));
        }
        return sb.reverse().toString();
    }
}
