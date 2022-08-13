package rosalind;

import java.io.*;
import java.util.*;

public class GRPH {
    private static int seq2num(String seq) {
        int num = 0;
        for (int i = 0; i < seq.length(); i++)
            num = num * 4 + "ACGT".indexOf(seq.charAt(i));
        return num;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        @SuppressWarnings("unchecked")
        List<String>[][] table = new ArrayList[64][2];
        String name = null, seq = null;
        for (int i = 0; i < 64; i++)
            for (int j = 0; j < 2; j++)
                table[i][j] = new ArrayList<String>();
        while (true) {
            if (!stdin.hasNext()) {
                table[seq2num(seq.substring(0, 3))][1].add(name);
                table[seq2num(seq.substring(seq.length()-3, seq.length()))][0].add(name);
                break;
            }
            String line = stdin.next();
            if (line.charAt(0) == '>') {
                if (name != null) {
                    table[seq2num(seq.substring(0, 3))][1].add(name);
                    table[seq2num(seq.substring(seq.length()-3, seq.length()))][0].add(name);
                }
                name = line.substring(1);
                seq = "";
            } else
                seq += line;
        }
        for (int i = 0; i < 64; i++)
            if (table[i][0].size() != 0 && table[i][1].size() != 0)
                for (String s : table[i][0])
                    for (String t : table[i][1])
                        if (!s.equals(t))
                            System.out.println(s + " " + t);
        stdin.close();
    }
}
