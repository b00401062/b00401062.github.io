package rosalind;

import java.io.*;
import java.util.*;

public class EDIT {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        List<String> reads = new ArrayList<>();
        String read = null;
        while (true) {
            if (!stdin.hasNext()) {
                reads.add(read);
                break;
            }
            String line = stdin.next();
            if (line.charAt(0) == '>') {
                if (read != null)
                    reads.add(read);
                read = "";
            } else
                read += line;
        }
        assert(reads.size() == 2);
        String s = reads.get(0), t = reads.get(1);
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 1; i <= s.length(); i++)
            dp[i][0] = i;
        for (int j = 1; j <= t.length(); j++)
            dp[0][j] = j;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= t.length(); j++) {
                int[] dirs = new int[] {
                    dp[i-1][j] + 1,
                    dp[i][j-1] + 1,
                    dp[i-1][j-1] + (s.charAt(i-1) == t.charAt(j-1) ? 0 : 1)
                };
                dp[i][j] = Arrays.stream(dirs).min().getAsInt();
            }
        System.out.println(dp[s.length()][t.length()]);
        stdin.close();
    }
}
