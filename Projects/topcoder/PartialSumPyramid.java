package topcoder;

class PartialSumPyramid {
    private static int modulo(int x, int M) {
        return (x % M + M) % M;
    }

    public static int[] reconstruct(int N, int M, int[] index, int[] value) {
        int[][] row = new int[2][N];
        for (int i = 0; i < N; i++) {
            int curRowIdx = i % 2;
            int preRowIdx = 1 - curRowIdx;
            row[curRowIdx][index[i]] = value[i];
            for (int j = index[i] - 1; j >= 0; j--) {
                row[curRowIdx][j] = modulo(row[preRowIdx][j] - row[curRowIdx][j + 1], M);
            }
            for (int j = index[i] + 1; j <= i; j++) {
                row[curRowIdx][j] = modulo(row[preRowIdx][j - 1] - row[curRowIdx][j - 1], M);
            }
        }
        return row[1 - N % 2];
    }
}
