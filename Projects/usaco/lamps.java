package usaco;

import java.io.*;
import java.util.*;

public class lamps {
    private static boolean[] move1(boolean[] in) {
        boolean[] out = in.clone();
        for (int i = 0; i < out.length; i++)
            out[i] = !out[i];
        return out;
    }
    private static boolean[] move2(boolean[] in) {
        boolean[] out = in.clone();
        for (int i = 0; i < out.length; i++)
            if (i % 2 == 0)
                out[i] = !out[i];
        return out;
    }
    private static boolean[] move3(boolean[] in) {
        boolean[] out = in.clone();
        for (int i = 0; i < out.length; i++)
            if (i % 2 == 1)
                out[i] = !out[i];
        return out;
    }
    private static boolean[] move4(boolean[] in) {
        boolean[] out = in.clone();
        for (int i = 0; i < out.length; i++)
            if (i % 3 == 0)
                out[i] = !out[i];
        return out;
    }
    private static String bool2str(boolean[] in) {
        String out = "";
        for (int i = 0; i < in.length; i++)
            out += in[i] ? '1' : '0';
        return out;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("lamps.in"));
        PrintWriter stdout = new PrintWriter(new File("lamps.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        int N = stdin.nextInt();
        int C = stdin.nextInt();
        List<Integer> on_set = new ArrayList<>();
        List<Integer> off_set = new ArrayList<>();
        for (int num = stdin.nextInt(); num != -1; num = stdin.nextInt())
            on_set.add(num - 1);
        for (int num = stdin.nextInt(); num != -1; num = stdin.nextInt())
            off_set.add(num - 1);
        boolean[] lights = new boolean[N];
        Arrays.fill(lights, true);
        final int[] dict = new int[] { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
        final boolean[][] moves = new boolean[][] {
            lights,
            move1(lights),
            move2(lights),
            move1(move2(lights)),
            move3(lights),
            move1(move3(lights)),
            move2(move3(lights)),
            move1(move2(move3(lights))),
            move4(lights),
            move1(move4(lights)),
            move2(move4(lights)),
            move1(move2(move4(lights))),
            move3(move4(lights)),
            move1(move3(move4(lights))),
            move2(move3(move4(lights))),
            move1(move2(move3(move4(lights))))
        };
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 16; i++)
            if (C - dict[i] >= 0 && (C - dict[i]) % 2 == 0) {
                boolean legal = true;
                for (int on : on_set)
                    if (!moves[i][on])
                        legal = false;
                for (int off : off_set)
                    if (moves[i][off])
                        legal = false;
                if (legal)
                    list.add(bool2str(moves[i]));
            }
        Collections.sort(list);
        if (list.size() == 0)
            stdout.println("IMPOSSIBLE");
        else for (String str : list)
            stdout.println(str);
        stdin.close();
    }
}
