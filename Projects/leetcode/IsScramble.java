package leetcode;

import java.util.HashMap;
import java.util.Map;

class IsScramble {
    public static boolean isScramble(String s1, String s2) {
        final int N = s1.length();
        if (N == 0) return false;
        if (s1.equals(s2)) return true;
        final Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < N; i++) {
            final char c1 = s1.charAt(i);
            final char c2 = s2.charAt(i);
            final int count1 = counts.getOrDefault(c1, 0) + 1;
            if (count1 == 0) counts.remove(c1);
            else counts.put(c1, count1);
            final int count2 = counts.getOrDefault(c2, 0) - 1;
            if (count2 == 0) counts.remove(c2);
            else counts.put(c2, count2);
            if (
                counts.isEmpty() &&
                isScramble(s1.substring(i + 1), s2.substring(i + 1)) &&
                isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
            ) return true;
        }
        if (!counts.isEmpty()) return false;
        for (int i = 0; i < N; i++) {
            final char c1 = s1.charAt(i);
            final char c2 = s2.charAt(N - i - 1);
            final int count1 = counts.getOrDefault(c1, 0) + 1;
            if (count1 == 0) counts.remove(c1);
            else counts.put(c1, count1);
            final int count2 = counts.getOrDefault(c2, 0) - 1;
            if (count2 == 0) counts.remove(c2);
            else counts.put(c2, count2);
            if (
                counts.isEmpty() &&
                isScramble(s1.substring(i + 1), s2.substring(0, N - i - 1)) &&
                isScramble(s1.substring(0, i + 1), s2.substring(N - i - 1))
            ) return true;
        }
        return false;
    }
}
