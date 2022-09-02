package leetcode;

import java.util.*;
import java.util.stream.*;

class LeetCode {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Map<Character, Integer>, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> counter = new HashMap<>();
            for (Character chr : str.toCharArray()) {
                int count = counter.getOrDefault(chr, 0) + 1;
                counter.put(chr, count);
            }
            List<String> group = groups.getOrDefault(counter, new ArrayList<>());
            group.add(str);
            groups.put(counter, group);
        }
        return groups.values().stream().collect(Collectors.toList());
    }
}
