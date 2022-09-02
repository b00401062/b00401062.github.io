package rosalind;

import java.io.*;
import java.util.*;

public class SSEQ {
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
        String seq = reads.get(0), pat = reads.get(1);
        int i = 0, j = 0;
        for (; j < pat.length(); j++)
            for (; i < seq.length(); i++)
                if (seq.charAt(i) == pat.charAt(j)) {
                    System.out.println(++i);
                    break;
                }
        stdin.close();
    }
}
