package usaco;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ttwo {
    private enum Direction {
        NORTH(0), EAST(1), SOUTH(2), WEST(3);
        public final int value;
        Direction(int value) { this.value = value; }
        public int getValue() { return this.value; }
    }
    private static class Player {
        private final int[][] DELTA = new int[][] { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        private final Direction[] TURN = new Direction[] { Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH };
        int[] coordinate;
        Direction direction;
        Player(int[] coordinate, Direction direction) {
            this.coordinate = coordinate;
            this.direction = direction;
        }
        int[] getCoordinate() { return coordinate; }
        void move(boolean[][] obstacles) {
            int i = direction.getValue();
            final int[] next = new int[] { coordinate[0] + DELTA[i][0], coordinate[1] + DELTA[i][1] };
            if (obstacles[next[0]][next[1]]) {
                direction = TURN[i];
            } else {
                coordinate[0] = next[0];
                coordinate[1] = next[1];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(new File("ttwo.in"));
        PrintWriter stdout = new PrintWriter(new File("ttwo.out"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> stdout.flush()));
        boolean[][] obstacles = new boolean[12][12];
        for (int i = 0; i < 12; i++) {
            Arrays.fill(obstacles[i], true);
        }
        Player farmer = null, cow = null;
        for (int i = 1; i <= 10; i++) {
            String line = stdin.next();
            for (int j = 1; j <= 10; j++) {
                switch (line.charAt(j-1)) {
                    case '.':
                        obstacles[i][j] = false;
                        break;
                    case 'F':
                        farmer = new Player(new int[] { i, j }, Direction.NORTH);
                        obstacles[i][j] = false;
                        break;
                    case 'C':
                        cow = new Player(new int[] { i, j }, Direction.NORTH);
                        obstacles[i][j] = false;
                        break;
                    default:
                        break;
                }
            }
        }
        for (int i = 1; i <= 160000; i++) {
            farmer.move(obstacles);
            cow.move(obstacles);
            if (Arrays.equals(farmer.getCoordinate(), cow.getCoordinate())) {
                stdout.println(i);
                stdin.close();
                stdout.close();
                return;
            }
        }
        stdout.println(0);
        stdin.close();
    }
}
