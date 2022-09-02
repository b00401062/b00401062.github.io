package usaco;

import java.io.*;
import java.util.*;

public class palsquare {
    private static boolean isPalindrome(String str) {
        return new StringBuffer(str).reverse().toString().equals(str);
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("palsquare.in"));
        PrintWriter stdout = new PrintWriter(new File("palsquare.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int B = stdin.nextInt();
        for (int i = 1; i <= 300; i++)
            if (isPalindrome(Integer.toString(i * i, B)))
                stdout.println(Integer.toString(i, B).toUpperCase() + " " + Integer.toString(i * i, B).toUpperCase());
        stdin.close();
    }
}
