package usaco;

import java.io.*;
import java.util.*;

public class runround {
    private static boolean isRunRound(String num) {
        Set<Integer> covered = new HashSet<Integer>();
        int num_len = num.length();
        int digit = num.charAt(0) - '0';
        for (int cnt = 0, pos = 0; cnt < num_len; cnt++) {
            pos = (digit + pos) % num_len;
            digit = num.charAt(pos) - '0';
            if (covered.contains(digit) || digit == 0)
                return false;
            covered.add(digit);
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("runround.in"));
        PrintWriter stdout = new PrintWriter(new File("runround.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int n = stdin.nextInt();
        for (n++; !isRunRound(Integer.toString(n)); n++);
        stdout.println(n);
        stdin.close();
    }
}
