package codechef;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KNPSK {
    private static class Record {
        public final long cost;
        public final int oneCount;
        public final int twoCount;

        Record(long cost, int oneCount, int twoCount) {
            this.cost = cost;
            this.oneCount = oneCount;
            this.twoCount = twoCount;
        }

        public long cost() {
            return cost;
        }
    }

    private static long[] solve(List<Integer> ones, List<Integer> twos) {
        Collections.sort(ones);
        Collections.sort(twos);
        final int m = ones.size() + twos.size() * 2;
        final Record[] records = new Record[m + 1];
        records[0] = new Record(0, ones.size(), twos.size());
        records[1] = (
            ones.size() == 0 ? new Record(0, ones.size(), twos.size()) :
            new Record(ones.get(ones.size() - 1), ones.size() - 1, twos.size())
        );
        for (int i = 2; i <= m; i++) {
            Record record1 = records[i - 1];
            long cost0 = record1.cost;
            long cost1 = record1.oneCount == 0 ? Long.MIN_VALUE : record1.cost + ones.get(record1.oneCount - 1);
            Record record2 = records[i - 2];
            long cost2 = record2.twoCount == 0 ? Long.MIN_VALUE : record2.cost + twos.get(record2.twoCount - 1);
            long maxCost = Math.max(cost0, Math.max(cost1, cost2));
            records[i] = (
                maxCost == cost1 ? new Record(maxCost, record1.oneCount - 1, record1.twoCount) :
                maxCost == cost2 ? new Record(maxCost, record2.oneCount, record2.twoCount - 1) :
                new Record(maxCost, record1.oneCount, record1.twoCount)
            );
        }
        return Arrays.stream(records).skip(1).mapToLong(Record::cost).toArray();
    }

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = stdin.nextInt();
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int w = stdin.nextInt();
            int c = stdin.nextInt();
            (w == 1 ? ones : twos).add(c);
        }
        final long[] costs = solve(ones, twos);
        System.out.println(
            Arrays.stream(costs)
            .mapToObj(Long::toString)
            .collect(Collectors.joining(" "))
        );
        stdin.close();
    }
}
