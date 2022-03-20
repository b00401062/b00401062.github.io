package codechef

import java.util.*

object MARBLES {
    private fun choose(n: Int, k: Int): Long {
        var res: Long = 1
        for (i in 0 until k) {
            res = res * (n - i) / (i + 1)
        }
        return res
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var T = stdin.nextInt()
        while (T-- > 0) {
            val N = stdin.nextInt()
            val K = stdin.nextInt()
            println(choose(N - 1, K - 1))
        }
        stdin.close()
    }
}