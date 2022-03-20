package usaco;

import java.io.*;
import java.util.*;

public class beads {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("beads.in"));
        PrintWriter stdout = new PrintWriter(new File("beads.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int max = 0;
        int N = stdin.nextInt();
        String necklace = stdin.next();
        necklace += necklace;
        for (int i = 0; i < N; i++) {
            char c = necklace.charAt(i);
            int state = (c == 'w') ? 0 : 1;
            int current = 0;
            int j = i;
            while (state <= 2) {
                while (j < N + i && (necklace.charAt(j) == c || necklace.charAt(j) == 'w')) {
                    current++;
                    j++;
                }
                state++;
                c = necklace.charAt(j);
            }
            max = Math.max(max, current);
        }
        stdout.println(max);
        stdin.close();
    }
}
