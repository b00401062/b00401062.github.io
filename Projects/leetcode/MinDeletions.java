package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class MinDeletions {
    public static int minDeletions(String s) {
        Map<Character, Integer> table = new HashMap<>();
        for (char c : s.toCharArray()) {
            table.put(c, table.getOrDefault(c, 0) + 1);
        }
        final int[] frequencies = table.values().stream()
        .sorted(Comparator.reverseOrder())
        .mapToInt(Integer::intValue).toArray();
        int minDeletion = 0;
        for (int i = 1; i < frequencies.length; i++) {
            final int delta = frequencies[i] - Math.max(0, frequencies[i - 1] - 1);
            if (delta <= 0) continue;
            frequencies[i] -= delta;
            minDeletion += delta;
        }
        return minDeletion;
    }
}
