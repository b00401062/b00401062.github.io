package leetcode;

import java.util.HashMap;
import java.util.Map;

class LeetCode {
    public static int maxOperations(int[] nums, int k) {
        final Map<Integer, Integer> table = new HashMap<>();
        for (int num : nums) {
            table.put(num, table.getOrDefault(num, 0) + 1);
        }
        int opCount = 0;
        for (Integer num1 : table.keySet()) {
            int num2 = k - num1;
            int numCount1 = table.get(num1);
            int numCount2 = table.getOrDefault(num2, 0);
            if (numCount1 == 0 || numCount2 == 0) continue;
            if (num1 == num2) {
                opCount += numCount1 / 2;
                table.put(num1, numCount1 % 2);
            } else {
                int deltaCount = Math.min(numCount1, numCount2);
                opCount += deltaCount;
                table.put(num1, numCount1 - deltaCount);
                table.put(num2, numCount2 - deltaCount);
            }
        }
        return opCount;
    }
}
