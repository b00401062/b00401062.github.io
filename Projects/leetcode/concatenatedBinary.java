package leetcode;

class LeetCode {
    static final int MODULO = 1000000007;

    private static int leftShift(int n, int bitShift) {
        for (int i = 0; i < bitShift; i++) {
            n = (n << 1) % MODULO;
        }
        return n;
    }

    public static int concatenatedBinary(int n) {
        int numerator = 0;
        for (int i = 1; i <= n; i++) {
            int bitShift = (int) (Math.log(i) / Math.log(2)) + 1;
            numerator = (leftShift(numerator, bitShift) + i) % MODULO;
        }
        return numerator;
    }
}
