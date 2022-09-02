package rosalind;

import java.io.*;
import java.util.*;

public class LONG {
    public static void main(String args[]) throws IOException {
        Scanner stdin = new Scanner(System.in);
        List<String> reads = new ArrayList<>();
        String seq = null;
        while (true) {
            if (!stdin.hasNext()) {
                reads.add(seq);
                break;
            }
            String line = stdin.next();
            if (line.charAt(0) == '>') {
                if (seq != null)
                    reads.add(seq);
                seq = "";
            } else
                seq += line;
        }
        reads.sort(Collections.reverseOrder(Comparator.comparingInt(String::length)));
        String genome = reads.remove(0);
        while (reads.size() > 0) {
            for (int i = 0; i < reads.size(); i++) {
                String read = reads.get(i);
                boolean matched = false;
                for (int j = 0; j < read.length()/2; j++)
                    if (read.substring(j, read.length()).equals(genome.substring(0, read.length()-j))) {
                        genome = read.substring(0, j) + genome;
                        matched = true;
                        break;
                    }
                if (matched) {
                    reads.remove(i);
                    break;
                }
                for (int j = read.length()/2; j <= read.length(); j++)
                    if (read.substring(0, j).equals(genome.substring(genome.length()-j))) {
                        genome = genome + read.substring(j);
                        matched = true;
                        break;
                    }
                if (matched) {
                    reads.remove(i);
                    break;
                }
            }
        }
        System.out.println(genome);
        stdin.close();
    }
}
