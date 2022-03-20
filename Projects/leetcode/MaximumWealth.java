package leetcode;

import java.util.Arrays;
import java.util.function.ToIntFunction;

class MaximumWealth {
    private static ToIntFunction<int[]> sum = account ->
        Arrays.stream(account).sum();

    public static int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(sum).max().getAsInt();
    }
}
