package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class DDIMMST {
    private static int distance(Point p1, Point p2) {
        final int D = p1.x.length;
        int w = 0;
        for (int i = 0; i < D; i++) {
            w += Math.abs(p1.x[i] - p2.x[i]);
        }
        return w;
    }

    public static void main(String[] args) throws Exception {
        final Field queue = PriorityQueue.class.getDeclaredField("queue");
        queue.setAccessible(true);
        final Method siftUp = PriorityQueue.class.getDeclaredMethod("siftUp", int.class, Object.class);
        siftUp.setAccessible(true);
        final Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int N = stdin.nextInt();
        final int D = stdin.nextInt();
        final Point[] p = new Point[N];
        for (int n = 0; n < N; n++) {
            final int[] x = new int[D];
            for (int d = 0; d < D; d++) {
                x[d] = stdin.nextInt();
            }
            p[n] = new Point(x);
        }
        int weight = 0;
        final PriorityQueue<Point> pool = new PriorityQueue<>(N, Comparator.comparingInt(Point::w).reversed());
        pool.addAll(Arrays.asList(p));
        final Object[] array = (Object[]) queue.get(pool);
        while (!pool.isEmpty()) {
            final Point s = pool.remove();
            Point t = null;
            for (int n = 0; n < N && (t = (Point) array[n]) != null; n++) {
                final int w = distance(s, t);
                if (w > t.w) {
                    t.set(w);
                    siftUp.invoke(pool, n, t);
                }
            }
            weight += s.w;
        }
        System.out.println(weight);
        stdin.close();
    }

    private static class Point {
        private final int[] x;
        private int w = 0;

        public Point(int[] x) {
            this.x = x;
        }

        public int w() {
            return this.w;
        }

        public void set(int w) {
            this.w = w;
        }
    }
}
