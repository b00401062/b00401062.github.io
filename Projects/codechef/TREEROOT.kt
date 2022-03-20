package codechef

import java.util.*

object TREEROOT {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var T = stdin.nextInt()
        while (T-- > 0) {
            var sumRoot = 0
            var sumCldr = 0
            var N = stdin.nextInt()
            while (N-- > 0) {
                sumRoot += stdin.nextInt()
                sumCldr += stdin.nextInt()
            }
            println(sumRoot - sumCldr)
        }
        stdin.close()
    }
}