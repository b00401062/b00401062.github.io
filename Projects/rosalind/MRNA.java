package rosalind;

import java.io.*;
import java.util.*;

public class MRNA {
    private static final int[] TABLE = new int[] { 4, 0, 2, 2, 2, 2, 4, 2, 3, 0, 2, 6, 1, 2, 0, 4, 2, 6, 6, 4, 0, 4, 1, 0, 2, 0 };
    public static void main(String args[]) throws IOException {
        Scanner stdin = new Scanner(System.in);
        PrintStream stdout = System.out;
        String seq = stdin.next();
        int count = 3;
        for (int i = 0; i < seq.length(); i++)
            count = count * TABLE[seq.charAt(i)-'A'] % 1000000;
        stdout.println(count);
        stdin.close();
    }
}
