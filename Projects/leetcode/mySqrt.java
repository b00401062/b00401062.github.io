package leetcode;

class LeetCode {
    private static long myRecursiveSqrt(final long guess, final int x) {
        return (
            guess * guess <= x && x < (guess + 1) * (guess + 1) ? guess :
            myRecursiveSqrt((guess + x / guess) / 2, x)
        );
    }

    public static int mySqrt(final int x) {
        return (
            x == 0 ? 0 :
            x == 1 ? 1 :
            (int) myRecursiveSqrt(x / 2, x)
        );
    }
}
