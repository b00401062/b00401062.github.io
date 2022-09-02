package leetcode;

class LeetCode {
    public static int numberOfMatches(int n) {
        int number = 0;
        while (n != 1) {
            number += n / 2;
            n = (n - 1) / 2 + 1;
        }
        return number;
    }
}
