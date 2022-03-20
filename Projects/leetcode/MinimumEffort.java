package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class MinimumEffort {
    public static int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(task -> task[1] - task[0]));
        int minimumEffort = 0;
        for (int[] task : tasks) {
            minimumEffort = Math.max(minimumEffort + task[0], task[1]);
        }
        return minimumEffort;
    }
}
