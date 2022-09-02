package leetcode;

class LeetCode {
    public static int maximumScore(int a, int b, int c) {
        int min = Math.min(Math.min(a, b), c);
        int max = Math.max(Math.max(a, b), c);
        int mid = a ^ b ^ c ^ min ^ max;
        return Math.min(max, min + mid) + Math.max(min + mid - max, 0) / 2;
    }
}
