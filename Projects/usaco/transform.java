package usaco;

import java.io.*;
import java.util.*;

public class transform {
    private static char[][] rotate(char[][] before) {
        int N = before.length;
        char[][] after = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                after[j][N-i-1] = before[i][j];
        return after;
    }
    private static char[][] reflect(char[][] before) {
        int N = before.length;
        char[][] after = new char[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                after[i][N-j-1] = before[i][j];
        return after;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("transform.in"));
        PrintWriter stdout = new PrintWriter(new File("transform.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.close()));
        int N = stdin.nextInt();
        char[][] before = new char[N][N];
        char[][] after = new char[N][N];
        for (int i = 0; i < N; i++)
            before[i] = stdin.next().toCharArray();
        for (int i = 0; i < N; i++)
            after[i] = stdin.next().toCharArray();
        char[][] rt090 = rotate(before);
        char[][] rt180 = rotate(rt090);
        char[][] rt270 = rotate(rt180);
        if (Arrays.deepEquals(after, rt090))
            stdout.println('1');
        else if (Arrays.deepEquals(after, rt180))
            stdout.println('2');
        else if (Arrays.deepEquals(after, rt270))
            stdout.println('3');
        else if (Arrays.deepEquals(after, reflect(before)))
            stdout.println('4');
        else if (Arrays.deepEquals(after, reflect(rt090)))
            stdout.println('5');
        else if (Arrays.deepEquals(after, reflect(rt180)))
            stdout.println('5');
        else if (Arrays.deepEquals(after, reflect(rt270)))
            stdout.println('5');
        else if (Arrays.deepEquals(after, before))
            stdout.println('6');
        else
            stdout.println('7');
        stdin.close();
    }
}
