package leetcode

internal object WinnerSquareGame {
    fun winnerSquareGame(n: Int): Boolean {
        val winners = BooleanArray(n + 1)
        for (i in 0..n) {
            if (winners[i]) {
                continue
            }
            var k = 1
            while (i + k * k <= n) {
                winners[i + k * k] = true
                k++
            }
        }
        return winners[n]
    }
}