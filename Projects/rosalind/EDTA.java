package rosalind;

import java.io.*;
import java.util.*;

public class EDTA {
    private static String[] lcs(String s, String t) {
        int[][] table = new int[s.length()+1][t.length()+1];
        for (int i = 1; i <= s.length(); i++)
            table[i][0] = i;
        for (int j = 1; j <= t.length(); j++)
            table[0][j] = j;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= t.length(); j++) {
                table[i][j] = Arrays.stream(new int[] {
                    table[i-1][j-1] + (s.charAt(i-1) == t.charAt(j-1) ? 0 : 1),
                    table[i-1][j] + 1,
                    table[i][j-1] + 1
                }).min().getAsInt();
            }
        StringBuilder[] lcs = new StringBuilder[] { new StringBuilder(), new StringBuilder() };
        int i = s.length(), j = t.length();
        while (i > 0 && j > 0) {
            if (table[i][j] == table[i-1][j-1] + (s.charAt(i-1) == t.charAt(j-1) ? 0 : 1)) {
                lcs[0].append(s.charAt(--i));
                lcs[1].append(t.charAt(--j));
            } else if (table[i][j] == table[i-1][j] + 1) {
                lcs[0].append(s.charAt(--i));
                lcs[1].append('-');
            } else if (table[i][j] == table[i][j-1] + 1) {
                lcs[0].append('-');
                lcs[1].append(t.charAt(--j));
            }
        }
        System.out.println(table[s.length()][t.length()]);
        return new String[] { lcs[0].reverse().toString(), lcs[1].reverse().toString() };
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        String s = "", t = "";
        String line = stdin.next();
        while (stdin.hasNext()) {
            if ((line = stdin.next()).charAt(0) == '>')
                break;
            s += line;
        }
        while (stdin.hasNext())
            t += stdin.next();
        String[] lcs = lcs(s, t);
        Arrays.stream(lcs).forEach(System.out::println);
        stdin.close();
    }
}
