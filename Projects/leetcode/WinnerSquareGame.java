package leetcode;

class WinnerSquareGame {
    public static boolean winnerSquareGame(final int n) {
        final boolean[] winners = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (winners[i]) {
                continue;
            }
            for (int k = 1; i + k * k <= n; k++) {
                winners[i + k * k] = true;
            }
        }
        return winners[n];
    }
}
