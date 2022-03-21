package codechef;

import java.util.Scanner;

class ADASHOP2 {
    private static final int[][] TAIL_STEPS = new int[][]{
            new int[]{2, 2},
            new int[]{3, 1},
            new int[]{1, 3},
            new int[]{2, 4},
            new int[]{1, 5},
            new int[]{5, 1},
            new int[]{6, 2},
            new int[]{7, 1},
            new int[]{1, 7},
            new int[]{2, 8},
            new int[]{8, 2},
            new int[]{7, 3},
            new int[]{8, 4},
            new int[]{4, 8},
            new int[]{5, 7},
            new int[]{6, 8},
            new int[]{8, 6},
            new int[]{7, 7},
            new int[]{8, 8}
    };

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        while (t-- > 0) {
            int r0 = stdin.nextInt();
            int c0 = stdin.nextInt();
            if (r0 != 1 || c0 != 1) {
                System.out.println(2 + TAIL_STEPS.length);
                System.out.printf("%d %d\n", (r0 + c0) / 2, (r0 + c0) / 2);
                System.out.printf("%d %d\n", 1, 1);
            } else {
                System.out.println(TAIL_STEPS.length);
            }
            for (int[] tailStep : TAIL_STEPS) {
                System.out.printf("%d %d\n", tailStep[0], tailStep[1]);
            }
        }
        stdin.close();
    }
}
