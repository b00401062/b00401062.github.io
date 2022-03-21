package codechef;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class RUNDIR {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int n = stdin.nextInt();
            Child[] children = new Child[n];
            double LT = Double.POSITIVE_INFINITY, RT = Double.POSITIVE_INFINITY;
            for (int i = 0; i < n; i++)
                children[i] = new Child(stdin.nextInt(), stdin.nextInt());
            Arrays.sort(children, Comparator.comparingInt(child -> child.x));
            for (int i = 1; i < n; i++) {
                double lt = Math.max(
                        Math.min(LT, children[i].setDir(Dir.LT).time(children[i - 1].setDir(Dir.LT))),
                        Math.min(RT, children[i].setDir(Dir.LT).time(children[i - 1].setDir(Dir.RT))));
                double rt = Math.max(
                        Math.min(LT, children[i].setDir(Dir.RT).time(children[i - 1].setDir(Dir.LT))),
                        Math.min(RT, children[i].setDir(Dir.RT).time(children[i - 1].setDir(Dir.RT))));
                LT = lt;
                RT = rt;
            }
            double optimal = Math.max(LT, RT);
            System.out.println(optimal == Double.POSITIVE_INFINITY ? -1 : optimal);
        }
    }

    private enum Dir {
        LT(-1), RT(1);
        private final int dir;

        Dir(int dir) {
            this.dir = dir;
        }

        public int toInt() {
            return this.dir;
        }
    }

    private static class Child {
        int x, v;
        Dir dir;

        Child(int x, int v) {
            this.x = x;
            this.v = v;
        }

        Child setDir(Dir dir) {
            this.dir = dir;
            return this;
        }

        public double time(Child that) {
            int x = that.x - this.x;
            int v = that.v * that.dir.toInt() - this.v * this.dir.toInt();
            if (v == 0) return Double.POSITIVE_INFINITY;
            double time = (double) x / v;
            return time > 0 ? Double.POSITIVE_INFINITY : -time;
        }
    }
}
