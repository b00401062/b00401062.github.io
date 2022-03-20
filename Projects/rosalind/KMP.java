package rosalind;

import java.io.*;
import java.util.*;

public class KMP {
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
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        StringBuilder read = new StringBuilder();
        stdin.next();
        while (stdin.hasNext())
            read.append(stdin.next());
        Arrays.stream(preprocess(read.toString())).map(x -> x+1).forEach(System.out::println);
        stdin.close();
    }
}
