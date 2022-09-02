package usaco;

import java.io.*;
import java.util.*;

public class preface {
    private static final int[] keys = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
    private static final String[] values = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    private static Map<Integer, String> dict = new HashMap<>(13);
    private static String toRoman(int num) {
        String roman = "";
        while (num > 0)
            for (int i = keys.length - 1; i >= 0; i--)
                if (num >= keys[i]) {
                    num -= keys[i];
                    roman += dict.get(keys[i]);
                    break;
                }
        return roman;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("preface.in"));
        PrintWriter stdout = new PrintWriter(new File("preface.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int N = stdin.nextInt();
        for (int i = 0; i < keys.length; i++)
            dict.put(keys[i], values[i]);
        int[] counter = new int[26];
        for (int i = 1; i <= N; i++) {
            String str = toRoman(i);
            str.chars().forEach((chr) -> counter[chr - 'A']++);
        }
        for (char chr : new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' })
            if (counter[chr - 'A'] > 0)
                stdout.println(chr + " " + counter[chr - 'A']);
        stdin.close();
    }
}
