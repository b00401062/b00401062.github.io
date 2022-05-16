package rosalind;

import java.io.*;
import java.util.*;

public class SCSP {
    private static String scs(String s, String t) {
        int[][] table = new int[s.length()+1][t.length()+1];
        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= t.length(); j++)
                table[i][j] = s.charAt(i-1) == t.charAt(j-1) ? table[i-1][j-1]+1 : Math.max(table[i-1][j], table[i][j-1]);
        StringBuilder scs = new StringBuilder();
        int i = s.length(), j = t.length();
        while (i > 0 && j > 0) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                scs.append(s.charAt(i-1));
                i--; j--;
            } else if (table[i][j] == table[i-1][j]) {
                scs.append(s.charAt(i-1));
                i--;
            } else if (table[i][j] == table[i][j-1]) {
                scs.append(t.charAt(j-1));
                j--;
            }
        }
        return s.substring(0, i) + t.substring(0, j) + scs.reverse().toString();
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        System.out.println(scs(stdin.next(), stdin.next()));
        stdin.close();
    }
}
