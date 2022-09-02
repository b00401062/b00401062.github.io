package leetcode;

import java.util.HashMap;
import java.util.Map;

class LeetCode {
    public static int countBalls(int lowLimit, int highLimit) {
        final Map<Integer, Integer> counts = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            final int sum = Integer.toString(i).chars().map(c -> c - '0').sum();
            counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        }
        return counts.values().stream().mapToInt(c -> c).max().getAsInt();
    }
}
