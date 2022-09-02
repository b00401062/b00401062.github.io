package usaco;

import java.io.*;
import java.util.*;

public class dualpal {
    private static boolean isPalindrome(String str) {
        return new StringBuffer(str).reverse().toString().equals(str);
    }
    private static boolean isDualPal(int num) {
        int count = 0;
        for (int b = 2; b <= 10; b++)
            if (isPalindrome(Integer.toString(num, b)))
                count++;
        return count >= 2;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("dualpal.in"));
        PrintWriter stdout = new PrintWriter(new File("dualpal.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int N = stdin.nextInt();
        int S = stdin.nextInt();
        while (N-- > 0) {
            boolean flag = true;
            while (flag) {
                int num = ++S;
                if (isDualPal(num)) {
                    stdout.println(num);
                    flag = false;
                    break;
                }
            }
        }
        stdin.close();
    }
}
