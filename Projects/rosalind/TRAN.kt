package rosalind;

import java.io.*;
import java.util.*;

public class TRAN {
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
        String s1 = reads.get(0), s2 = reads.get(1);
        int transitions = 0, transversions = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) == s2.charAt(i))
                continue;
            else if (s1.charAt(i) == 'A' && s2.charAt(i) == 'G' || s1.charAt(i) == 'G' && s2.charAt(i) == 'A' || s1.charAt(i) == 'C' && s2.charAt(i) == 'T' || s1.charAt(i) == 'T' && s2.charAt(i) == 'C')
                transitions++;
            else
                transversions++;
        System.out.println((double) transitions/transversions);
        stdin.close();
    }
}
