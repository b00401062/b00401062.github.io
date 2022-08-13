package rosalind;

import java.io.*;
import java.util.*;

public class GC {
    private static double ratio(String seq) {
        return (double) seq.chars().filter(x -> x == 'C' || x == 'G').count() / seq.length();
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        Map<String, Double> ratios = new HashMap<>();
        String name = null, seq = null;
        while (true) {
            if (!stdin.hasNext()) {
                ratios.put(name, ratio(seq));
                break;
            }
            String line = stdin.next();
            if (line.charAt(0) == '>') {
                if (name != null)
                    ratios.put(name, ratio(seq));
                name = line.substring(1);
                seq = "";
            } else
                seq += line;
        }
        double ratio = 0;
        for (String key : ratios.keySet()) {
            if (ratios.get(key) > ratio) {
                name = key;
                ratio = ratios.get(key);
            }
        }
        System.out.println(name);
        System.out.println(ratio * 100);
        stdin.close();
    }
}
