package rosalind;

import java.io.*;
import java.util.*;

public class SUBS {
    private static int[] preprocess(String t) {
        int[] table = new int[t.length()];
        table[0] = -1;
        int k = -1;
        for (int i = 1; i < t.length(); i++) {
            while (k >= 0 && t.charAt(k+1) != t.charAt(i))
                k = table[k];
            if (t.charAt(k+1) == t.charAt(i))
                k++;
            table[i] = k;
        }
        return table;
    }
    private static int[] match(String s, String t, int[] table) {
        List<Integer> indices = new ArrayList<>();
        int k = -1;
        for (int i = 0; i < s.length(); i++) {
            while (k > 0 && t.charAt(k+1) != s.charAt(i))
                k = table[k];
            if (t.charAt(k+1) == s.charAt(i))
                k++;
            if (k == t.length() - 1) {
                indices.add(i + 1 - t.length());
                k = table[k];
            }
        }
        return indices.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        String s = stdin.next(), t = stdin.next();
        Arrays.stream(match(s, t, preprocess(t))).map(x -> x + 1).forEach(System.out::println);
        stdin.close();
    }
}
