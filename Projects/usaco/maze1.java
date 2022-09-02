package usaco;

import java.io.*;
import java.util.*;

public class maze1 {
    private static List<int[]> entrances(char[][] maze) {
        List<int[]> entrances = new ArrayList<>();
        for (int i = 1; i < maze.length; i += 2) {
            if (maze[i][0] == ' ') {
                entrances.add(new int[]{ i, 1 });
                maze[i][0] = '|';
            }
            if (maze[i][maze[0].length-1] == ' ') {
                entrances.add(new int[]{ i, maze[0].length-2 });
                maze[i][maze[0].length-1] = '|';
            }
        }
        for (int j = 1; j < maze[0].length; j += 2) {
            if (maze[0][j] == ' ') {
                entrances.add(new int[] { 1, j });
                maze[0][j] = '-';
            }
            if (maze[maze.length-1][j] == ' ') {
                entrances.add(new int[] { maze.length-2, j });
                maze[maze.length-1][j] = '-';
            }
        }
        return entrances;
    }
    private static List<int[]> neighbors(char[][] maze, int[] vertex) {
        List<int[]> neighbors = new ArrayList<>();
        final int[][] DELTA = new int[][] { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        for (int[] delta : DELTA)
            if (maze[vertex[0] + delta[0]][vertex[1] + delta[1]] == ' ')
                neighbors.add(new int[] { vertex[0] + delta[0] * 2, vertex[1] + delta[1] * 2 });
        return neighbors;
    }
    private static int[][] search(char[][] maze, int[] source) {
        final int w = maze[0].length;
        final int h = maze.length;
        int[][] visited = new int[h][w];
        visited[source[0]][source[1]] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int[] vertex = queue.remove();
            for (int[] neighbor : neighbors(maze, vertex))
                if (visited[neighbor[0]][neighbor[1]] == 0) {
                    visited[neighbor[0]][neighbor[1]] = visited[vertex[0]][vertex[1]] + 1;
                    queue.add(neighbor);
                }
        }
        return visited;
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("maze1.in"));
        PrintWriter stdout = new PrintWriter(new File("maze1.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        final int w = 2 * stdin.nextInt() + 1;
        final int h = 2 * stdin.nextInt() + 1;
        stdin.nextLine();
        char[][] maze = new char[h][];
        for (int i = 0; i < h; i++)
            maze[i] = stdin.nextLine().toCharArray();
        List<int[]> entrances = entrances(maze);
        int[][] visited0 = search(maze, entrances.get(0));
        int[][] visited1 = search(maze, entrances.get(1));
        int[][] visited = new int[h][w];
        for (int i = 1; i < h; i += 2)
            for (int j = 1; j < w; j += 2)
                visited[i][j] = Math.min(visited0[i][j], visited1[i][j]);
        stdout.println(Arrays.stream(visited).flatMapToInt(Arrays::stream).max().getAsInt());
        stdin.close();
    }
}
