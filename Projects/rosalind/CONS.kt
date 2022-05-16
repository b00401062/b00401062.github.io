package rosalind;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CONS {
    private static void put(int[][] table, String seq) {
        for (int i = 0; i < table.length; i++)
            table[i]["ACGT".indexOf(seq.charAt(i))]++;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int[][] table = null;
        String seq = null;
        while (true) {
            if (!stdin.hasNext()) {
                put(table, seq);
                break;
            }
            String line = stdin.next();
            if (line.charAt(0) == '>') {
                if (seq != null) {
                    if (table == null)
                        table = new int[seq.length()][4];
                    put(table, seq);
                }
                seq = "";
            } else
                seq += line;
        }
        for (int i = 0; i < table.length; i++) {
            int max = Arrays.stream(table[i]).max().getAsInt();
            System.out.print("ACGT".charAt(Arrays.stream(table[i]).boxed().collect(Collectors.toList()).indexOf(max)));
        }
        System.out.println();
        for (int j = 0; j < 4; j++) {
            System.out.print(String.format("%c:", "ACGT".charAt(j)));
            for (int i = 0; i < table.length; i++)
                System.out.print(String.format(" %d", table[i][j]));
            System.out.println();
        }
        stdin.close();
    }
}
