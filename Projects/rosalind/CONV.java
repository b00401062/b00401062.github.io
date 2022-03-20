package rosalind;

import java.io.*;
import java.util.*;

public class CONV {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        double[] S1 = Arrays.stream(stdin.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] S2 = Arrays.stream(stdin.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<String, Integer> counter = new HashMap<>();
        for (double s1 : S1)
            for (double s2 : S2) {
                String key = String.format("%.5f", s1 - s2);
                counter.put(key, counter.getOrDefault(key, 0) + 1);
            }
        counter.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(1)
        .forEach(e -> {
            System.out.println(e.getValue());
            System.out.println(e.getKey());
        });
        stdin.close();
    }
}
