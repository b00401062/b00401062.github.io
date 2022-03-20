package codechef

import java.util.*

internal object CUTBOARD {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var T = stdin.nextInt()
        while (T-- > 0) {
            val N = stdin.nextInt()
            val M = stdin.nextInt()
            println((N - 1) * (M - 1))
        }
        stdin.close()
    }
}