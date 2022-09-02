package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class POSAND {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            if (n == 1) {
                System.out.println(1);
                continue;
            } else if (Integer.bitCount(n) == 1) {
                System.out.println(-1);
                continue;
            }
            int[] seq = IntStream.rangeClosed(1, n).toArray();
            seq[0] = 2;
            seq[1] = 3;
            seq[2] = 1;
            for (int i = 4; i < n; i *= 2) {
                seq[i - 1] = i + 1;
                seq[i] = i;
            }
            System.out.println(Arrays.stream(seq).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
        stdin.close();
    }
}
