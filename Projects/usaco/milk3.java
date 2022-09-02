package usaco;

import java.io.*;
import java.util.*;

public class milk3 {
    private static boolean[][][] visited;
    private static boolean[] result;
    private static int[] capacities;
    private static int[] pour(int[] values, int i, int j) {
        int[] result = values.clone();
        if (result[j] + result[i] <= capacities[j]) {
            result[j] += result[i];
            result[i] = 0;
            return result;
        } else {
            result[i] -= capacities[j] - result[j];
            result[j] = capacities[j];
            return result;
        }
    }
    private static void solve(int[] values) {
        if (visited[values[0]][values[1]][values[2]])
            return;
        visited[values[0]][values[1]][values[2]] = true;
        if (values[0] == 0)
            result[values[2]] = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (i != j) {
                    int[] values_new = pour(values, i, j);
                    solve(values_new);
                }
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("milk3.in"));
        PrintWriter stdout = new PrintWriter(new File("milk3.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        capacities = new int[]{ stdin.nextInt(), stdin.nextInt(), stdin.nextInt() };
        int[] values = { 0, 0, capacities[2] };
        visited = new boolean[capacities[0]+1][capacities[1]+1][capacities[2]+1];
        result = new boolean[capacities[2]+1];
        solve(values);
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < result.length; i++)
            if (result[i])
                indices.add(i);
        for (int i = 0; i < indices.size(); i++) {
            stdout.print(indices.get(i));
            stdout.print(i == indices.size() - 1 ? '\n' : ' ');
        }
        stdin.close();
    }
}
