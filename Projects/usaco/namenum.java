package usaco;

import java.io.*;
import java.util.*;

public class namenum {
    public static void main(String[] args) throws IOException {
        Scanner fin1 = new Scanner(new File("namenum.in"));
        Scanner fin2 = new Scanner(new File("dict.txt"));
        PrintWriter stdout = new PrintWriter(new File("namenum.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        char[] map = new char[256];
        map['A'] = map['B'] = map['C'] = '2';
        map['D'] = map['E'] = map['F'] = '3';
        map['G'] = map['H'] = map['I'] = '4';
        map['J'] = map['K'] = map['L'] = '5';
        map['M'] = map['N'] = map['O'] = '6';
        map['P'] = map['R'] = map['S'] = '7';
        map['T'] = map['U'] = map['V'] = '8';
        map['W'] = map['X'] = map['Y'] = '9';
        String num = fin1.next();
        int num_len = num.length();
        boolean flag = false;
        while (fin2.hasNext()) {
            String word = fin2.next();
            if (word.length() != num_len)
                continue;
            for (int i = 0; i < num_len; i++) {
                if (map[word.charAt(i)] != num.charAt(i))
                    break;
                if (i == num_len - 1) {
                    flag = true;
                    stdout.println(word);
                }
            }
        }
        if (!flag)
            stdout.println("NONE");
        fin1.close();
        fin2.close();
    }
}
