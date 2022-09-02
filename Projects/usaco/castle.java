package usaco;

import java.io.*;
import java.util.*;

public class castle {
    private static int width;
    private static int height;
    private static int[][] walls;
    private static int[][] rooms;
    private static int[] size;
    private static void label(int label, int i, int j) {
        rooms[i][j] = label;
        if (rooms[i][j-1] == 0 && (walls[i][j] & 1) == 0 && (walls[i][j-1] & 4) == 0)
            label(label, i, j-1);
        if (rooms[i-1][j] == 0 && (walls[i][j] & 2) == 0 && (walls[i-1][j] & 8) == 0)
            label(label, i-1, j);
        if (rooms[i][j+1] == 0 && (walls[i][j] & 4) == 0 && (walls[i][j+1] & 1) == 0)
            label(label, i, j+1);
        if (rooms[i+1][j] == 0 && (walls[i][j] & 8) == 0 && (walls[i+1][j] & 2) == 0)
            label(label, i+1, j);
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("castle.in"));
        PrintWriter stdout = new PrintWriter(new File("castle.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        width = stdin.nextInt();
        height = stdin.nextInt();
        walls = new int[height+2][width+2];
        rooms = new int[height+2][width+2];
        for (int i = 1; i <= height; i++) {
            walls[i][0]  = 4;
            walls[i][width+1] = 1;
        }
        for (int j = 1; j <= width; j++) {
            walls[0][j] = 8;
            walls[height+1][j] = 2;
        }
        for (int i = 1; i <= height; i++)
            for (int j = 1; j <= width; j++)
                walls[i][j] = stdin.nextInt();
        int room_cnt = 0;
        for (int i = 1; i <= height; i++)
            for (int j = 1; j <= width; j++)
                if (rooms[i][j] == 0)
                    label(++room_cnt, i, j);
        size = new int[room_cnt+1];
        for (int i = 1; i <= height; i++)
            for (int j = 1; j <= width; j++)
                size[rooms[i][j]]++;
        int[] room_max = new int[4];
        for (int j = 1; j <= width; j++)
            for (int i = height; i >= 1; i--) {
                if (rooms[i][j] != rooms[i-1][j] && size[rooms[i][j]] + size[rooms[i-1][j]] > room_max[0])
                    room_max = new int[] { size[rooms[i][j]] + size[rooms[i-1][j]], i, j, 'N' };
                if (rooms[i][j] != rooms[i][j+1] && size[rooms[i][j]] + size[rooms[i][j+1]] > room_max[0])
                    room_max = new int[] { size[rooms[i][j]] + size[rooms[i][j+1]], i, j, 'E' };
            }
        stdout.println(room_cnt);
        stdout.println(Arrays.stream(size).max().getAsInt());
        stdout.println(room_max[0]);
        stdout.println(room_max[1] + " " + room_max[2] + " " + (char) room_max[3]);
        stdin.close();
    }
}
