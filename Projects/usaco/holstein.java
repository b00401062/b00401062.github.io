package usaco;

import java.io.*;
import java.util.*;

public class holstein {
    private static int V;
    private static int G;
    private static int[][] brands;
    private static int[] minScoop(int[] needs, int start) {
        if (Arrays.stream(needs).allMatch(x -> x <= 0))
            return new int[G];
        else if (start >= G)
            return null;
        int[] scoop0 = minScoop(needs, start + 1);
        for (int j = 0; j < V; j++)
            needs[j] -= brands[start][j];
        int[] scoop1 = minScoop(needs, start + 1);
        for (int j = 0; j < V; j++)
            needs[j] += brands[start][j];
        if (scoop1 != null)
            scoop1[start] = 1;
        if (scoop0 == null && scoop1 == null)
            return null;
        else if (scoop0 == null)
            return scoop1;
        else if (scoop1 == null)
            return scoop0;
        else if (Arrays.stream(scoop1).sum() <= Arrays.stream(scoop0).sum())
            return scoop1;
        return scoop0;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("holstein.in"));
        PrintWriter stdout = new PrintWriter(new File("holstein.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        V = stdin.nextInt();
        int[] needs = new int[V];
        for (int i = 0; i < V; i++)
            needs[i] = stdin.nextInt();
        G = stdin.nextInt();
        brands = new int[G][V];
        for (int i = 0; i < G; i++)
            for (int j = 0; j < V; j++)
                brands[i][j] = stdin.nextInt();
        int[] scoop_min = minScoop(needs, 0);
        stdout.print(Arrays.stream(scoop_min).sum());
        for (int i = 0; i < scoop_min.length; i++)
            if (scoop_min[i] == 1)
                stdout.print(" " + (i + 1));
        stdout.println();
        stdin.close();
    }
}
