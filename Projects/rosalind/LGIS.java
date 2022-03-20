package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class LGIS {
    private static List<Integer> dp(int[] s, int d) {
        int n = s.length;
        int[] len = new int[n], prv = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(prv, -1);
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if ((s[j] < s[i] ? 1-d : d) == 1 && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    prv[i] = j;
                }
        int m = IntStream.range(0, n).boxed().max(Comparator.comparingInt(i -> len[i])).get();
        List<Integer> dp = new ArrayList<>();
        do {
            dp.add(s[m]);
        } while ((m = prv[m]) != -1);
        Collections.reverse(dp);
        return dp;
    }
    public static void main(String args[]) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++)
            s[i] = stdin.nextInt();
        System.out.println(dp(s, 0).stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(dp(s, 1).stream().map(String::valueOf).collect(Collectors.joining(" ")));
        stdin.close();
    }
}
