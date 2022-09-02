package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class LeetCode {
    private static class Job {
        public final int startTime;
        public final int endTime;
        public final int profit;

        Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int endTime() {
            return endTime;
        }
    }

    private static int prevJobIdx(Job[] jobs, int i) {
        final Job job = jobs[i];
        while (--i >= 0 && jobs[i].endTime > job.startTime);
        return i;
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int n = profit.length;
        final Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(Job::endTime));
        final int[] cache = new int[n];
        cache[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            final Job job = jobs[i];
            final int prevJobIdx = prevJobIdx(jobs, i);
            cache[i] = Math.max(cache[i - 1], job.profit + (prevJobIdx == -1 ? 0 : cache[prevJobIdx]));
        }
        return cache[n - 1];
    }
}
